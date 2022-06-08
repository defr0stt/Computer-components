package ua.lpnu.computer_components.repo.pc_model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lpnu.computer_components.models.PcModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface PcModelRepository extends JpaRepository<PcModel,Long> {
    Optional<PcModel> findPcModelByCustomPcName(String name);
    Optional<PcModel> findPcModelById(Long id);
    boolean existsByCustomPcName(String name);
    boolean existsById(Long id);
    void deleteByCustomPcName(String name);
}
