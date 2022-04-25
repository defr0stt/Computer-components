package ua.lpnu.computer_components.controllers.CPU;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lpnu.computer_components.models.CPU;

import java.util.Optional;

@Repository     // data access
public interface CpuRepository extends JpaRepository<CPU,Long> {    // створення є важливим так, як
                                                                    // інший інтерфейс має велику кількість методів
                                                                    // для обробки даних
    // same to : SELECT * FROM cpu WHERE name = '...'
    // @Query("SELECT c FROM CPU c WHERE c.name = '...'")
    Optional<CPU> findCPUByName(String name);
}
