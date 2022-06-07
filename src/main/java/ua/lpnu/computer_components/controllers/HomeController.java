package ua.lpnu.computer_components.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lpnu.computer_components.models.ComponentData.*;
import ua.lpnu.computer_components.models.Components.CPU;
import ua.lpnu.computer_components.models.Components.Component;
import ua.lpnu.computer_components.repo.component.ComponentService;

import java.util.List;

@Controller
public class HomeController {

    private final ComponentService componentService;

    @Autowired
    public HomeController(ComponentService componentService) {
        this.componentService = componentService;
    }

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

    @GetMapping("/compare")
    public String compareGet(Model model){
        List<Component> supply = componentService.findComponentByType("Power supply");
        List<Component> cpu = componentService.findComponentByType("CPU");
        List<Component> gpu = componentService.findComponentByType("GPU");
        List<Component> cooler = componentService.findComponentByType("Cooler");
        List<Component> hardware = componentService.findComponentByType("Hardware");
        List<Component> aCase = componentService.findComponentByType("Case");
        List<Component> memory = componentService.findComponentByType("Memory");
        List<Component> mBoard = componentService.findComponentByType("Motherboard");
        List<Component> os = componentService.findComponentByType("OS");

        model.addAttribute("supply", supply);
        model.addAttribute("cpu", cpu);
        model.addAttribute("gpu", gpu);
        model.addAttribute("cooler", cooler);
        model.addAttribute("hardware", hardware);
        model.addAttribute("aCase", aCase);
        model.addAttribute("memory", memory);
        model.addAttribute("motherboard", mBoard);
        model.addAttribute("os", os);
        return "compare/compareGet";
    }
}
