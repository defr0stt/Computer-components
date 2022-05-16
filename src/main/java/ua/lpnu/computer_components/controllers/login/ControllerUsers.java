package ua.lpnu.computer_components.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerUsers {

    // showing favicon for logged account
    @RequestMapping("favicon.ico")
    @ResponseBody
    void favicon() {}

    @GetMapping("/login")
    public String loginPage(){
        return "login_page";
    }

}