package ua.lpnu.computer_components.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lpnu.computer_components.models.ComponentData.*;
import ua.lpnu.computer_components.models.Components.CPU;
import ua.lpnu.computer_components.models.Components.Component;
import ua.lpnu.computer_components.models.PcModel;
import ua.lpnu.computer_components.models.PcModelData.PcModelData;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.repo.component.ComponentService;
import ua.lpnu.computer_components.repo.pc_model.PcModelService;
import ua.lpnu.computer_components.repo.user.DefaultUserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ComponentService componentService;
    private final PcModelService pcModelService;
    private final DefaultUserService defaultUserService;

    @GetMapping("/")
    public String startAppWorking(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        List<PcModel> pcModels = pcModelService.findAllModels();
        model.addAttribute("pcModels",pcModels);
        return "home";
    }

    @GetMapping("/home/create_pc")
    public String homeCreate(Model model){
        PcModelData pcModelData = new PcModelData();
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
        model.addAttribute("pc_model",pcModelData);
        return "createPc/creatingPc";
    }

    @PostMapping("/home/create_pc")
    public String homeCreatePost(final PcModelData pcModelData){
        if(pcModelService.isPcPresent(pcModelData.getCustomPcName()) || pcModelData.getCustomPcName().length() < 3){
            return "redirect:/home/create_pc";
        }
        double price =  0;
        price += componentService.findByName(pcModelData.getCpuName()).getPrice();
        price += componentService.findByName(pcModelData.getGpuName()).getPrice();
        price += componentService.findByName(pcModelData.getCaseName()).getPrice();
        price += componentService.findByName(pcModelData.getCoolerName()).getPrice();
        price += componentService.findByName(pcModelData.getPowerSupplyName()).getPrice();
        price += componentService.findByName(pcModelData.getMemoryName()).getPrice();
        price += componentService.findByName(pcModelData.getOsName()).getPrice();
        price += componentService.findByName(pcModelData.getMotherboardName()).getPrice();
        price += componentService.findByName(pcModelData.getHardwareName()).getPrice();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = defaultUserService.getUser(((UserDetails) principal).getUsername());

        PcModel pcModel = new PcModel(pcModelData.getCustomPcName(),
                pcModelData.getCpuName(),
                pcModelData.getGpuName(),
                pcModelData.getCaseName(),
                pcModelData.getCoolerName(),
                pcModelData.getPowerSupplyName(),
                pcModelData.getMemoryName(),
                pcModelData.getOsName(),
                pcModelData.getMotherboardName(),
                pcModelData.getHardwareName(),
                price,
                user.getUsername());
        pcModelService.addNewComponent(pcModel);
        return "redirect:/home";
    }

    @GetMapping("/home/model/{id}")
    public String createdPcId(@PathVariable(value = "id") Long id, Model model){
        if (!pcModelService.isPcModelPresent(id)) {
            return "redirect:/home";
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = null;
        if(!principal.equals("anonymousUser")) {
            user = defaultUserService.getUser(((UserDetails) principal).getUsername());
        }

        Optional<PcModel> pcModelOptional = pcModelService.findPcById(id);
        ArrayList<PcModel> res = new ArrayList<>();
        pcModelOptional.ifPresent(res::add);
        model.addAttribute("pcModelOptional", res.get(0));
        model.addAttribute("pcModelOptional_name", res.get(0).getCustomPcName());
        model.addAttribute("username","loooool");
        if(user != null) {
            model.addAttribute("username",user.getUsername());
        }
        return "createPc/pcModelId";
    }

    @PostMapping("/home/model/{id}")
    public String deletePcId(@PathVariable(value = "id") Long id){
        if(pcModelService.isPcModelPresent(id)){
            pcModelService.deletePcModel(id);
            return "redirect:/home";
        }
        return "createPc/pcModelId";
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
