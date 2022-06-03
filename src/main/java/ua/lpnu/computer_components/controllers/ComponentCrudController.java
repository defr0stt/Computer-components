package ua.lpnu.computer_components.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lpnu.computer_components.models.ComponentData.*;
import ua.lpnu.computer_components.models.Components.*;
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
        model.addAttribute("hardware", new HardwareData());
        model.addAttribute("cooler", new CoolerData());
        model.addAttribute("gpu", new GpuData());
        model.addAttribute("memory", new MemoryData());
        model.addAttribute("motherboard", new MotherboardData());
        model.addAttribute("os", new OsData());
        model.addAttribute("supply", new PowerSupplyData());
        return "component_crud/create";
    }

    @PostMapping("/create")
    public String createCompPost(final @Valid CpuData cpuData,
                                 final @Valid CaseData caseData,
                                 final @Valid HardwareData hardwareData,
                                 final @Valid CoolerData coolerData,
                                 final @Valid GpuData gpuData,
                                 final @Valid MemoryData memoryData,
                                 final @Valid MotherboardData motherboardData,
                                 final @Valid OsData osData,
                                 final @Valid PowerSupplyData powerSupplyData){

        if(cpuData.getMaxFrequency() != null){
            cpuData.setTypeOfComponent("CPU");
            System.out.println(cpuData);
            CPU cpuCreation = new CPU(cpuData.getTypeOfComponent(),
                    cpuData.getName(),
                    cpuData.getType(),
                    cpuData.getSocket(),
                    cpuData.getPrice(),
                    cpuData.getYear(),
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
                                        caseData.getPrice(),
                                        caseData.getYear(),
                                         caseData.getType(),
                                         caseData.getColor());
            componentService.addNewComponent(caseCreation);
        } else if(hardwareData.getDiskBufferSize() != null){
            hardwareData.setTypeOfComponent("Hardware");
            Hardware hardware = new Hardware(hardwareData.getTypeOfComponent(),
                                             hardwareData.getName(),
                                             hardwareData.getPrice(),
                                            hardwareData.getYear(),
                                            hardwareData.getSize(),
                                            hardwareData.getDiskType(),
                                            hardwareData.getConnection(),
                                            hardwareData.getDiskBufferSize());
            componentService.addNewComponent(hardware);
        } else if(coolerData.getTdp() != null){
            coolerData.setTypeOfComponent("Cooler");
            Cooler cooler = new Cooler(coolerData.getTypeOfComponent(),
                    coolerData.getName(),
                    coolerData.getPrice(),
                    coolerData.getYear(),
                    coolerData.getType(),
                    coolerData.getTdp(),
                    coolerData.getSocket(),
                    coolerData.getSpeedBase(),
                    coolerData.getSpeedMax());
            componentService.addNewComponent(cooler);
        } else if(gpuData.getResolutionMax() != null){
            gpuData.setTypeOfComponent("GPU");
            GPU gpu = new GPU(gpuData.getTypeOfComponent(),
                    gpuData.getName(),
                    gpuData.getPrice(),
                    gpuData.getYear(),
                    gpuData.getChipName(),
                    gpuData.getMemoryType(),
                    gpuData.getMemorySize(),
                    gpuData.getCoolingSys(),
                    gpuData.getFrequency(),
                    gpuData.getResolutionMax());
            componentService.addNewComponent(gpu);
        } else if(memoryData.getDevice() != null){
            memoryData.setTypeOfComponent("Memory");
            Memory memory = new Memory(memoryData.getTypeOfComponent(),
                    memoryData.getName(),
                    memoryData.getPrice(),
                    memoryData.getYear(),
                    memoryData.getMemorySize(),
                    memoryData.getMemoryType(),
                    memoryData.getFrequency(),
                    memoryData.getDevice());
            componentService.addNewComponent(memory);
        } else if(motherboardData.getOutputs() != null){
            motherboardData.setTypeOfComponent("Motherboard");
            Motherboard motherboard = new Motherboard(motherboardData.getTypeOfComponent(),
                    motherboardData.getName(),
                    motherboardData.getPrice(),
                    motherboardData.getYear(),
                    motherboardData.getSocket(),
                    motherboardData.getMemory(),
                    motherboardData.getFrequency(),
                    motherboardData.getOutputs());
            componentService.addNewComponent(motherboard);
        } else if(osData.getDischarge() != null){
            osData.setTypeOfComponent("OS");
            OS os = new OS(osData.getTypeOfComponent(),
                    osData.getName(),
                    osData.getPrice(),
                    osData.getYear(),
                    osData.getEdition(),
                    osData.getDischarge());
            componentService.addNewComponent(os);
        } else if(powerSupplyData.getDeviceType() != null){
            powerSupplyData.setTypeOfComponent("Power supply");
            PowerSupply powerSupply = new PowerSupply(powerSupplyData.getTypeOfComponent(),
                    powerSupplyData.getName(),
                    powerSupplyData.getPrice(),
                    powerSupplyData.getYear(),
                    powerSupplyData.getPower(),
                    powerSupplyData.getDeviceType());
            componentService.addNewComponent(powerSupply);
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
        model.addAttribute("hardwareToUpdate",new Hardware());
        model.addAttribute("coolerToUpdate",new Cooler());
        model.addAttribute("gpuToUpdate",new GPU());
        model.addAttribute("boardToUpdate",new Motherboard());
        model.addAttribute("memoryToUpdate",new Memory());
        model.addAttribute("osToUpdate",new OS());
        model.addAttribute("supplyToUpdate",new PowerSupply());
        if(component.get().getTypeOfComponent().equals("CPU")){
            CPU cpu = (CPU) component.get();
            model.addAttribute("cpuToUpdate",cpu);
        } else if(component.get().getTypeOfComponent().equals("Case")) {
            Case aCase = (Case) component.get();
            model.addAttribute("caseToUpdate",aCase);
        } else if(component.get().getTypeOfComponent().equals("Hardware")){
            Hardware hardware = (Hardware) component.get();
            model.addAttribute("hardwareToUpdate",hardware);
        } else if(component.get().getTypeOfComponent().equals("Cooler")){
            Cooler cooler = (Cooler) component.get();
            model.addAttribute("coolerToUpdate",cooler);
        } else if(component.get().getTypeOfComponent().equals("GPU")){
            GPU gpu = (GPU) component.get();
            model.addAttribute("gpuToUpdate",gpu);
        } else if(component.get().getTypeOfComponent().equals("Motherboard")){
            Motherboard motherboard = (Motherboard) component.get();
            model.addAttribute("boardToUpdate",motherboard);
        } else if(component.get().getTypeOfComponent().equals("Memory")){
            Memory memory = (Memory) component.get();
            model.addAttribute("memoryToUpdate",memory);
        } else if(component.get().getTypeOfComponent().equals("OS")){
            OS os = (OS) component.get();
            model.addAttribute("osToUpdate",os);
        } else if(component.get().getTypeOfComponent().equals("Power supply")){
            PowerSupply powerSupply = (PowerSupply) component.get();
            model.addAttribute("supplyToUpdate",powerSupply);
        }
        model.addAttribute("componentType",component.get().getTypeOfComponent());
        model.addAttribute("componentName",component.get().getName());
        return "component_crud/update";
    }

    @PostMapping("/update/{id}")
    public String componentUpdateId(@PathVariable("id") Long id,
                                    final @Valid CPU cpu,
                                    final @Valid Case aCase,
                                    final @Valid Hardware hardware,
                                    final @Valid Cooler cooler,
                                    final @Valid GPU gpu,
                                    final @Valid Motherboard motherboard,
                                    final @Valid Memory memory,
                                    final @Valid OS os,
                                    final @Valid PowerSupply powerSupply){
        if(componentService.existComponent(id)){
            cpu.setTypeOfComponent("CPU");
            aCase.setTypeOfComponent("Case");
            hardware.setTypeOfComponent("Hardware");
            cooler.setTypeOfComponent("Cooler");
            gpu.setTypeOfComponent("GPU");
            motherboard.setTypeOfComponent("Motherboard");
            memory.setTypeOfComponent("Memory");
            os.setTypeOfComponent("OS");
            powerSupply.setTypeOfComponent("Power supply");
            if(cpu.getGraphic() != null){
                componentService.updateComponent(id,cpu);
            } else if (aCase.getColor() != null){
                componentService.updateComponent(id,aCase);
            } else if(hardware.getDiskBufferSize() != null){
                componentService.updateComponent(id,hardware);
            } else if(cooler.getTdp() != null){
                componentService.updateComponent(id,cooler);
            } else if(gpu.getResolutionMax() != null){
                componentService.updateComponent(id,gpu);
            } else if(motherboard.getOutputs() != null){
                componentService.updateComponent(id,motherboard);
            } else if(memory.getDevice() != null){
                componentService.updateComponent(id,memory);
            } else if(os.getDischarge() != null){
                componentService.updateComponent(id,os);
            } else if(powerSupply.getDeviceType() != null){
                componentService.updateComponent(id,powerSupply);
            }
        }
        return "redirect:/profile/update_delete";
    }
}
