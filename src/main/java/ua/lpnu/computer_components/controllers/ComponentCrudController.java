package ua.lpnu.computer_components.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lpnu.computer_components.models.ComponentData.CaseData;
import ua.lpnu.computer_components.models.ComponentData.CpuData;
import ua.lpnu.computer_components.models.Components.CPU;
import ua.lpnu.computer_components.models.Components.Case;
import ua.lpnu.computer_components.models.Components.Component;
import ua.lpnu.computer_components.repo.component.ComponentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/profile")
public class ComponentCrudController {

    private final ComponentService componentService;

    @GetMapping("/create")
    public String createComp(Model model){
        model.addAttribute("case_comp",new CaseData());
        model.addAttribute("cpu",new CpuData());
        return "component_crud/create";
    }

    @PostMapping("/create")
    public String createCompPost(final @Valid CpuData cpuData,
                                 final @Valid CaseData caseData){

        if(cpuData.getMaxFrequency() != null){
            cpuData.setTypeOfComponent("CPU");
            System.out.println(cpuData);
            CPU cpuCreation = new CPU(cpuData.getTypeOfComponent(),
                    cpuData.getName(),
                    cpuData.getType(),
                    cpuData.getSocket(),
                    Double.parseDouble(cpuData.getPrice()),
                    Integer.parseInt(cpuData.getYear()),
                    cpuData.getBaseFrequency(),
                    cpuData.getCore(),
                    cpuData.getThreadCount(),
                    cpuData.getMaxTemperature(),
                    cpuData.getGraphic(),
                    cpuData.getMaxFrequency());
            componentService.addNewComponent(cpuCreation);
        } else if(caseData.getColor() != null){
            caseData.setTypeOfComponent("Case");
            System.out.println(caseData);
            Case caseCreation = new Case(caseData.getTypeOfComponent(),
                                         caseData.getName(),
                    Double.parseDouble(caseData.getPrice()),
                    Integer.parseInt(caseData.getYear()),
                                         caseData.getType(),
                                         caseData.getColor());
            componentService.addNewComponent(caseCreation);
        }
        return "redirect:/profile/create";
    }

    @GetMapping("/update_delete")
    public String deleteComp(Model model){
        List<Component> components = componentService.getAllComponents();
        model.addAttribute("allComponents",components);
        return "component_crud/update_delete";
    }

    @PostMapping("/delete/{id}")
    public String componentDeleteId(@PathVariable("id") Long id){
        if(componentService.existComponent(id)){
            componentService.deleteComponent(id);
        }
        return "redirect:/profile/update_delete";
    }

    @GetMapping("/update/{id}")
    public String componentUpdate(@PathVariable("id") Long id, Model model){
        Optional<Component> component = componentService.findComponentById(id);
        model.addAttribute("cpuToUpdate",new CPU());
        model.addAttribute("caseToUpdate",new Case());
        if(component.get().getTypeOfComponent().equals("CPU")){
            CPU cpu = (CPU) component.get();
            model.addAttribute("cpuToUpdate",cpu);
        } else if(component.get().getTypeOfComponent().equals("Case")) {
            Case aCase = (Case) component.get();
            model.addAttribute("caseToUpdate",aCase);
        }
        model.addAttribute("componentType",component.get().getTypeOfComponent());
        model.addAttribute("componentName",component.get().getName());
        return "component_crud/update";
    }

    @PostMapping("/update/{id}")
    public String componentUpdateId(@PathVariable("id") Long id,
                                    final @Valid CPU cpu,
                                    final @Valid Case aCase
                                    ){
        if(componentService.existComponent(id)){
            cpu.setTypeOfComponent("CPU");
            aCase.setTypeOfComponent("Case");
            if(cpu.getTypeOfComponent().equals("CPU")){
                componentService.updateComponent(id,cpu);
            } else if (aCase.getTypeOfComponent().equals("Case")){
                componentService.updateComponent(id,aCase);
            }
        }
        return "redirect:/profile/update_delete";
    }
}
