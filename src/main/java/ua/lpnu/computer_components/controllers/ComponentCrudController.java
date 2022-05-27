package ua.lpnu.computer_components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lpnu.computer_components.models.ComponentData.CaseData;
import ua.lpnu.computer_components.models.ComponentData.CpuData;

@Controller
@RequestMapping("/profile")
public class ComponentCrudController {
    @GetMapping("/create")
    public String allUsersInfo(Model model){
        model.addAttribute("case_comp",new CaseData());
        model.addAttribute("cpu",new CpuData());
        return "component_crud/create";
    }
}
