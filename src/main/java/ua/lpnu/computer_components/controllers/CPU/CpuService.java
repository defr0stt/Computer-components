package ua.lpnu.computer_components.controllers.CPU;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lpnu.computer_components.models.CPU;

import java.util.List;
import java.util.Optional;

@Service
public class CpuService {

    private final CpuRepository cpuRepository;

    @Autowired
    public CpuService(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    public List<CPU> getCPU(){
        return cpuRepository.findAll();
    }

    public void addNewCpu(CPU cpu) {
        Optional<CPU> cpuOptional = cpuRepository.findCPUByName(cpu.getName());
        if(cpuOptional.isPresent()){
            throw new IllegalStateException("This cpu is already exists.");
        }
        cpuRepository.save(cpu);
    }

    public void deleteCpu(Long id) {
        if(cpuRepository.existsById(id)){
            cpuRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Cpu with this id doesn't exist.");
        }
    }

    public void updateCpu(Long id, String name) {
        CPU cpu = cpuRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Cpu with id=" + id + "doesn't exist"));
        if(cpu!=null){
            Optional<CPU> cpuOptional = cpuRepository.findCPUByName(name);
            if(cpuOptional.isPresent()){
                cpu.setName(name);
            }
        }
    }
}
