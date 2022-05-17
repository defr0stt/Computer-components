package ua.lpnu.computer_components.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.repo.user.UserService;

@Controller
public class ControllerUsers {

    private final UserService userService;

    @Autowired
    public ControllerUsers(UserService userService) {
        this.userService = userService;
    }

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
    public String regStart(){
        System.out.println("regStart");
        return "registration";
    }

    @PostMapping("/registration")
    public String regFin(@PathVariable(value = "username") String  username,
                         @PathVariable(value = "password") String password){
        if(userService.loadUserByUsername(username) != null){
            return "redirect:/home";
        }
        System.out.println(username + " = " + password);
        User user = new User(username,password,true,
                false,false,false,null);
        userService.createUser(user);

        return "redirect:/login";
    }
}