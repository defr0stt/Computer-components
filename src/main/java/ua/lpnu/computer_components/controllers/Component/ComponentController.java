package ua.lpnu.computer_components.controllers.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.models.Component;

import java.util.List;

@RestController
@RequestMapping("components")
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
}
