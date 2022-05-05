package ua.lpnu.computer_components.controllers.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.models.Component;

@Controller
@RequestMapping("/list")
public class ComponentController {

    private final ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

//    @GetMapping("{componentId}")
//    public List<Component> componentInfo(){
//        return componentService.getComponent();
//    }

    @GetMapping("/cpu")
    public String cpuList(Model model){
        Iterable<Component> cpuComponents = componentService.findComponentByType("CPU");
        model.addAttribute("cpuComponents",cpuComponents);
        return "listCPU";
    }


/*
    @GetMapping("/cpu/{id}")
    public String blogDetails(@PathVariable(value = "id") Long  id){

        if(!componentService.findComponent(id).isPresent()){
            return "redirect:/list";
        }

        Optional<Component> component = componentService.findComponent(id);
        ArrayList<Component> res = new ArrayList<>();
        component.ifPresent(res::add);
        return "blog-info";
    }


    @GetMapping
    public List<Component> componentInfo(){
        return componentService.getComponent();
    }

    @PostMapping
    public void registerComponent(@RequestBody Component component){
        componentService.addNewComponent(component);
    }

    @DeleteMapping("{componentId}")
    public void deleteComponent(@PathVariable("componentId") Long id){
        componentService.deleteComponent(id);
    }

    @PutMapping("{componentId}")
    public void updateComponent(@PathVariable("componentId") Long id,
                          @RequestParam(required = false) String name){
        componentService.updateComponent(id, name);
    }
 */
}
