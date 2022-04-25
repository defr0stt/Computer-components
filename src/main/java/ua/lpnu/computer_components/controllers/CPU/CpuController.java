package ua.lpnu.computer_components.controllers.CPU;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lpnu.computer_components.models.CPU;

import java.util.List;

@RestController
@RequestMapping("home_page/cpu")
public class CpuController {

    private final CpuService cpuService;

    @Autowired
    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }

    @GetMapping
    public List<CPU> cpuInfo(){
        return cpuService.getCPU();
    }

    @PostMapping
    public void registerCpu(@RequestBody CPU cpu){
        cpuService.addNewCpu(cpu);
    }

    @DeleteMapping("{cpuId}")
    public void deleteCpu(@PathVariable("cpuId") Long id){
        cpuService.deleteCpu(id);
    }

    @PutMapping("{cpuId}")
    public void updateCpu(@PathVariable("cpuId") Long id,
                          @RequestParam(required = false) String name){
        cpuService.updateCpu(id, name);
    }
}
