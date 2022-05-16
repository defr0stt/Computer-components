package ua.lpnu.computer_components.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lpnu.computer_components.repo.component.ComponentService;
import ua.lpnu.computer_components.models.Component;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/list")
public class ControllerComponents {

    private final ComponentService componentService;

    @Autowired
    public ControllerComponents(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/cpu")
    public String cpuList(Model model){
        Iterable<Component> cpuComponents = componentService.findComponentByType("CPU");
        model.addAttribute("cpuComponents",cpuComponents);
        return "list_components/cpu/listCPU";
    }

    @GetMapping("/cpu/{id}")
    public String cpuDetailedInfo(@PathVariable(value = "id") Long  id, Model model){
        if(!componentService.existComponent(id)){
            return "redirect:/list/cpu";
        }

        Optional<Component> cpu = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        cpu.ifPresent(res::add);
        model.addAttribute("cpu", res.get(0));
        model.addAttribute("cpu_name", res.get(0).getName());
        return "list_components/cpu/listCPUid";
    }

    //    AMD
//    <svg xmlns="http://www.w3.org/2000/svg" height="50" width="75" viewBox="-120 -47.7005 1040 286.203"><path d="M187.888 178.122H143.52l-13.573-32.738H56.003l-12.366 32.738H0L66.667 12.776h47.761zM91.155 52.286L66.912 116.53h50.913zm257.901-39.51h35.88v165.346h-41.219V74.842l-44.608 51.877h-6.301l-44.605-51.877V178.12h-41.219V12.776h35.88l53.092 61.336zm140.319 0c60.364 0 91.391 37.573 91.391 82.909 0 47.517-30.058 82.437-96 82.437h-68.369V12.776zm-31.762 135.041h26.906c41.457 0 53.823-28.129 53.823-52.377 0-28.368-15.276-52.363-54.308-52.363h-26.422v104.74zM800 0v189.21l-51.972-51.975V51.981h-85.259L610.797 0zM609.2 190.802h74.889l53.505-53.506h-74.886V62.397L609.2 115.903z"/></svg>
//
//    Intel
//    <img aria-describedby="caption-attachment-18268" loading="lazy" class="wp-image-18268 lazyloaded" src="https://cdn.freelogovectors.net/wp-content/uploads/2016/12/intel_logo-785x518.png" alt="Intel Logo png" width="395" height="260" title="Intel Logo png vector" sizes="(max-width: 395px) 100vw, 395px" srcset="https://cdn.freelogovectors.net/wp-content/uploads/2016/12/intel_logo-785x518.png 785w, https://cdn.freelogovectors.net/wp-content/uploads/2016/12/intel_logo-500x330.png 500w" data-ll-status="loaded">


    //    @GetMapping("{componentId}")
//    public List<Component> componentInfo(){
//        return componentService.getComponent();
//    }
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
