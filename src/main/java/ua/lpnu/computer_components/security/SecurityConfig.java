package ua.lpnu.computer_components.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.repo.user.DefaultUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static ua.lpnu.computer_components.security.ApplicationRole.ADMIN;
import static ua.lpnu.computer_components.security.ApplicationRole.USER;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final DefaultUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home","/about",
                        "/list", "/list/**",
                        "/registration","/registration**",
                        "/css/**","/js/**","/icons/**","/image/**").permitAll()
                .antMatchers("/component_crud","/component_crud/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll().defaultSuccessUrl("/profile",true)
                .and()
                    .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))
                    .key("securedSession")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");
    }

    private static List<UserDetails> details;

    public static List<UserDetails> getDetails() {
        return details;
    }

    @Bean
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager(){
        details = new ArrayList<>();
        details.add(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMIN.name())
                .build());
        List<UserEntity> userEntities = userService.getAllUsers();
        for(UserEntity userEntity : userEntities){
            details.add(
                    User.builder()
                            .username(userEntity.getUsername())
                            .password(userEntity.getPassword())
                            .roles(USER.name())
                            .build());
        }
        System.out.println(details);
        return new InMemoryUserDetailsManager(details);
    }

//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails admin =  User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles(ADMIN.name())
//                .build();
//
//        List<UserEntity> userEntities = userService.getAllUsers();
//        details = new ArrayList<>();
//        for(UserEntity userEntity : userEntities){
//            details.add(
//                    User.builder()
//                            .username(userEntity.getUsername())
//                            .password(userEntity.getPassword())
//                            .roles(USER.name())
//                            .build());
//        }
//        details.add(admin);
//        System.out.println(details);
//        return new InMemoryUserDetailsManager(
//                details
//        );
//    }
}