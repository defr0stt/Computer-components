package ua.lpnu.computer_components.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.repo.user.UserAlreadyExistException;
import ua.lpnu.computer_components.repo.user.UserData;
import ua.lpnu.computer_components.repo.user.UserRepository;
import ua.lpnu.computer_components.repo.user.UserService;
import ua.lpnu.computer_components.security.SecurityConfig;

import javax.validation.Valid;

import static ua.lpnu.computer_components.security.ApplicationRole.USER;


@Controller
@AllArgsConstructor
public class ControllerUsers {

    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private UserService userService;
    private PasswordEncoder passwordEncoder;


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
            bindingResult.rejectValue("username", "userData.username",
                    "An account already exists for this username or " +
                    "password or username is too short (less than 6 characters)");
            model.addAttribute("registrationForm", userData);
            return "registration";
        }
        inMemoryUserDetailsManager.createUser(User
                .withUsername(userData.getUsername())
                .password(passwordEncoder.encode(userData.getPassword()))
                .roles(USER.name())
                .build());
        return "redirect:/login";
    }

}