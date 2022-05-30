package ua.lpnu.computer_components.repo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lpnu.computer_components.models.Components.CPU;
import ua.lpnu.computer_components.models.Components.Case;
import ua.lpnu.computer_components.models.Components.Component;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentService(ComponentRepository cpuRepository) {
        this.componentRepository = cpuRepository;
    }

//    public List<Component> getComponent(){
//        return componentRepository.findAll();
//    }

    public void addNewComponent(Component component) {
        Optional<Component> componentOptional = componentRepository.findComponentByName(component.getName());
        if(componentOptional.isPresent()){
            throw new IllegalStateException("This component is already exists.");
        }
        componentRepository.save(component);
    }

    public boolean existComponent(Long id){
        if(componentRepository.existsById(id)){
            return true;
        }
        return false;
    }

    public Optional<Component> findComponentById(Long id){
        return componentRepository.findById(id);
    }

    public List<Component> findComponentByType(String type){
        return componentRepository.findByTypeOfComponent(type);
    }

    public List<Component> getAllComponents(){
        return componentRepository.findAll();
    }

    public void deleteComponent(Long id) {
        if(componentRepository.existsById(id)){
            componentRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Component with this id doesn't exist.");
        }
    }

    public void updateComponent(Long id, Component component) {
        if(component!=null){
            Optional<Component> componentOptional = componentRepository.findById(id);
            if(component.getTypeOfComponent().equals("CPU")){
                CPU cpu = (CPU)(componentOptional.get());
                CPU otherCpu = (CPU) component;
                if(!cpu.equals(otherCpu)){
                    CPU temp = CPU.checkParams(cpu,otherCpu);
                    cpu = temp;
                    componentRepository.deleteById(cpu.getId());
                    componentRepository.save(cpu);
                }

            } else if (component.getTypeOfComponent().equals("Case")){
                Case aCase = (Case)(componentOptional.get());
                Case otherCase = (Case) component;
                if(!aCase.equals(otherCase)){
                    Case temp = Case.checkParams(aCase,otherCase);
                    aCase = temp;
                    componentRepository.deleteById(aCase.getId());
                    componentRepository.save(aCase);
                }
            }
        }
    }
}
