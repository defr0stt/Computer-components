package ua.lpnu.computer_components.repo.pc_model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lpnu.computer_components.models.Components.Component;
import ua.lpnu.computer_components.models.PcModel;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PcModelService {

    private final PcModelRepository pcModelRepository;

    public void addNewComponent(PcModel pcModel) {
        Optional<PcModel> pcModelOptional = pcModelRepository.findPcModelByCustomPcName(pcModel.getCustomPcName());
        if(pcModelOptional.isPresent()){
            throw new IllegalStateException("This component is already exists.");
        }
        pcModelRepository.save(pcModel);
    }

    public boolean isPcPresent(Long id){
        if(pcModelRepository.existsById(id)){
            return true;
        }
        return false;
    }

    public boolean isPcPresent(String name){
        if(pcModelRepository.existsByCustomPcName(name)){
            return true;
        }
        return false;
    }

    public Optional<PcModel> findPcById(Long id){
        return pcModelRepository.findPcModelById(id);
    }

    public Optional<PcModel> findPcByName(String name){
        return pcModelRepository.findPcModelByCustomPcName(name);
    }

    public void deletePcModel(Long id){
        if(pcModelRepository.existsById(id)){
            pcModelRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Component with this id doesn't exist.");
        }
    }

    public void deletePcModel(String name){
        if(pcModelRepository.existsByCustomPcName(name)){
            pcModelRepository.deleteByCustomPcName(name);
        } else {
            throw new IllegalStateException("Component with this id doesn't exist.");
        }
    }

    public List<PcModel> findAllModels(){
        return pcModelRepository.findAll();
    }

    public boolean isPcModelPresent (Long id){
        return pcModelRepository.existsById(id);
    }
}
