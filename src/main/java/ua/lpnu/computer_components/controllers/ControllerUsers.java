package ua.lpnu.computer_components.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.password.PasswordReader;
import ua.lpnu.computer_components.repo.user.*;
import ua.lpnu.computer_components.security.SecurityConfig;

import javax.mail.MessagingException;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static ua.lpnu.computer_components.security.ApplicationRole.USER;


@Controller
@AllArgsConstructor
public class ControllerUsers {

    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private DefaultUserService defaultUserService;


    // showing favicon for logged account
    @RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}

    @GetMapping("/login")
    public String loginPage(){
        return "login_page";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println(username);
        UserEntity user = defaultUserService.getUser(username);
        model.addAttribute("u_email",username);
        if(user == null){
            username = "admin";
        } else {
            username = user.getUsername();
            String date = user.getRegisterDate().getDayOfMonth() + "-" + user.getRegisterDate().getMonthValue() +
                    "-" + user.getRegisterDate().getYear() + " " + user.getRegisterDate().getHour() +
                    ":" + user.getRegisterDate().getMinute() + ":" + user.getRegisterDate().getSecond();
            model.addAttribute("u_date", date);
        }
        model.addAttribute("u_name",username);
        return "personal_logout_page";
    }

    @GetMapping("/registration")
    public String register(final Model model){
        model.addAttribute("userData",new UserData());
        return "registration";
    }

    @PostMapping("/registration")
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "registration";
        }
        try {
            userService.register(userData);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email",
                    "An account already exists for this email or " +
                    "password or username is too short");
            model.addAttribute("registrationForm", userData);
            return "registration";
        }
        inMemoryUserDetailsManager.createUser(User
                .builder()
                .username(userData.getEmail())
                .password(passwordEncoder.encode(userData.getPassword()))
                .roles(USER.name())
                .build());
        PasswordReader.writeInFile(userData.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/recover")
    public String recoverPage(Model model){
        model.addAttribute("userData",new UserData());
        return "forgot_password";
    }

    @PostMapping("/recover")
    public String recoverProcess(final @Valid UserData userData, final BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("recoverForm", userData);
            return "forgot_password";
        }
        if(userService.checkIfUserExist(userData.getEmail())){
            UserEntity userEntity = defaultUserService.getUser(userData.getEmail());
            String password = "";
            PasswordReader.checkIfExists("");
            List<String> temp = PasswordReader.getPasswords();
            for(String s:temp){
                if(passwordEncoder.matches(s,userEntity.getPassword())){
                    password = s;
                    break;
                }
            }
            try {
                defaultUserService.recoverPassword(userEntity.getEmail(), userEntity.getUsername(),
                        password);
                return "redirect:/login";
            } catch (Exception e){
                return "redirect:/forgot_password";
            }
        } else {
            bindingResult.rejectValue("email", "userData.email",
                    "There is no account for this email");
            return "forgot_password";
        }
    }

    @GetMapping("/all_users")
    public String allUsersInfo(Model model){
        List<UserEntity> userEntities = defaultUserService.getAllUsers();
        model.addAttribute("allUsers",userEntities);
        return "all_users";
    }

    // Deleting a person
    @PostMapping("/all_users/{id}")
    public String usersDelete(@PathVariable("id") Long id){
        if(defaultUserService.checkIfUserExist(id)){
            defaultUserService.deleteUser(id);
            return "redirect:/all_users";
        }
        return "redirect:/home";
    }

    @GetMapping("/change_password")
    public String changePassword(Model model){
        model.addAttribute("userData",new UserData());
        return "change_password";
    }

    @PostMapping("/change_password")
    public String changePasswordPost(final @Valid UserData userData, final BindingResult bindingResult, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userData.getPassword().length() < 6){
            bindingResult.rejectValue("password", "userData.password",
                    "This password is too short");
            return "change_password";
        }
        String newPassword = passwordEncoder.encode(userData.getPassword());
        String email = ((UserDetails) principal).getUsername();
        defaultUserService.updatePassword(email,newPassword);

        inMemoryUserDetailsManager.updatePassword(User
                .builder()
                .username((((UserDetails) principal)).getUsername())
                .password(passwordEncoder.encode(userData.getPassword()))
                .roles(USER.name())
                .build(),newPassword);

        PasswordReader.writeInFile(userData.getPassword());

        return "redirect:/profile";
    }
}