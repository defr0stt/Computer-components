package ua.lpnu.computer_components.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.repo.user.UserAlreadyExistException;
import ua.lpnu.computer_components.repo.user.UserData;
import ua.lpnu.computer_components.repo.user.UserService;

import javax.validation.Valid;


@Controller
public class ControllerUsers {

    @Autowired
    private UserService userService;

    // showing favicon for logged account
    @RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}

    @GetMapping("/login")
    public String loginPage(){
        return "login_page";
    }

    @GetMapping("/profile")
    public String profile(){
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
                    "An account already exists for this username.");
            model.addAttribute("registrationForm", userData);
            return "registration";
        }
        return "home";
    }

}