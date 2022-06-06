package ua.lpnu.computer_components.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lpnu.computer_components.repo.component.ComponentService;
import ua.lpnu.computer_components.models.Components.Component;

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
    public String cpuList(Model model) {
        Iterable<Component> cpuComponents = componentService.findComponentByType("CPU");
        model.addAttribute("cpuComponents", cpuComponents);
        return "list_components/cpu/listCPU";
    }

    @GetMapping("/cpu/{id}")
    public String cpuDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/cpu";
        }

        Optional<Component> cpu = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        cpu.ifPresent(res::add);
        model.addAttribute("cpu", res.get(0));
        model.addAttribute("cpu_name", res.get(0).getName());
        return "list_components/cpu/listCPUid";
    }

    @GetMapping("/gpu")
    public String gpuList(Model model) {
        Iterable<Component> gpuComponents = componentService.findComponentByType("GPU");
        model.addAttribute("gpuComponents", gpuComponents);
        return "list_components/gpu/listGPU";
    }

    @GetMapping("/gpu/{id}")
    public String gpuDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/gpu";
        }

        Optional<Component> gpu = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        gpu.ifPresent(res::add);
        model.addAttribute("gpu", res.get(0));
        model.addAttribute("gpu_name", res.get(0).getName());
        return "list_components/gpu/listGPUid";
    }

    @GetMapping("/cooler")
    public String coolerList(Model model) {
        Iterable<Component> coolerComponents = componentService.findComponentByType("Cooler");
        model.addAttribute("coolerComponents", coolerComponents);
        return "list_components/cooler/listCooler";
    }

    @GetMapping("/cooler/{id}")
    public String coolerDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/cooler";
        }

        Optional<Component> cooler = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        cooler.ifPresent(res::add);
        model.addAttribute("cooler", res.get(0));
        model.addAttribute("cooler_name", res.get(0).getName());
        return "list_components/cooler/listCoolerId";
    }

    @GetMapping("/hardware")
    public String hardwareList(Model model) {
        Iterable<Component> hardwareComponents = componentService.findComponentByType("Hardware");
        model.addAttribute("hardwareComponents", hardwareComponents);
        return "list_components/hardware/listHardware";
    }

    @GetMapping("/hardware/{id}")
    public String hardwareDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/hardware";
        }

        Optional<Component> hardware = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        hardware.ifPresent(res::add);
        model.addAttribute("hardware", res.get(0));
        model.addAttribute("hardware_name", res.get(0).getName());
        return "list_components/hardware/listHardwareId";
    }

    @GetMapping("/memory")
    public String memoryList(Model model) {
        Iterable<Component> memoryComponents = componentService.findComponentByType("Memory");
        model.addAttribute("memoryComponents", memoryComponents);
        return "list_components/memory/listMemory";
    }

    @GetMapping("/memory/{id}")
    public String memoryDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/memory";
        }

        Optional<Component> memory = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        memory.ifPresent(res::add);
        model.addAttribute("memory", res.get(0));
        model.addAttribute("memory_name", res.get(0).getName());
        return "list_components/memory/listMemoryId";
    }

    @GetMapping("/motherboard")
    public String motherboardList(Model model) {
        Iterable<Component> motherboardComponents = componentService.findComponentByType("Motherboard");
        model.addAttribute("motherboardComponents", motherboardComponents);
        return "list_components/motherboard/listMotherboard";
    }

    @GetMapping("/motherboard/{id}")
    public String motherboardDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/motherboard";
        }

        Optional<Component> motherboard = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        motherboard.ifPresent(res::add);
        model.addAttribute("motherboard", res.get(0));
        model.addAttribute("motherboard_name", res.get(0).getName());
        return "list_components/motherboard/listMotherboardId";
    }

    @GetMapping("/case")
    public String caseList(Model model) {
        Iterable<Component> caseComponents = componentService.findComponentByType("Case");
        model.addAttribute("caseComponents", caseComponents);
        return "list_components/case/listCase";
    }

    @GetMapping("/case/{id}")
    public String caseDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/case";
        }

        Optional<Component> aCase = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        aCase.ifPresent(res::add);
        model.addAttribute("aCase", res.get(0));
        model.addAttribute("aCase_name", res.get(0).getName());
        return "list_components/case/listCaseId";
    }

    @GetMapping("/os")
    public String osList(Model model) {
        Iterable<Component> osComponents = componentService.findComponentByType("OS");
        model.addAttribute("osComponents", osComponents);
        return "list_components/os/listOs";
    }

    @GetMapping("/os/{id}")
    public String osDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/os";
        }

        Optional<Component> os = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        os.ifPresent(res::add);
        model.addAttribute("os", res.get(0));
        model.addAttribute("os_name", res.get(0).getName());
        return "list_components/os/listOsId";
    }

    @GetMapping("/power_supply")
    public String supplyList(Model model) {
        Iterable<Component> supplyComponents = componentService.findComponentByType("Power supply");
        model.addAttribute("supplyComponents", supplyComponents);
        return "list_components/supply/listSupply";
    }

    @GetMapping("/power_supply/{id}")
    public String supplyDetailedInfo(@PathVariable(value = "id") Long id, Model model) {
        if (!componentService.existComponent(id)) {
            return "redirect:/list/power_supply";
        }

        Optional<Component> supply = componentService.findComponentById(id);
        ArrayList<Component> res = new ArrayList<>();
        supply.ifPresent(res::add);
        model.addAttribute("supply", res.get(0));
        model.addAttribute("supply_name", res.get(0).getName());
        return "list_components/supply/listSupplyId";
    }
}
