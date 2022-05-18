package ua.lpnu.computer_components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String startAppWorking(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}