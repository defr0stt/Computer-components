package ua.lpnu.computer_components.repo.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lpnu.computer_components.models.Components.Component;

import java.util.List;
import java.util.Optional;

@Repository     // data access
public interface ComponentRepository extends JpaRepository<Component,Long> {    // створення є важливим так, як
                                                                    // інший інтерфейс має велику кількість методів
                                                                    // для обробки даних
    // same to : SELECT * FROM cpu WHERE name = '...'
    // @Query("SELECT c FROM CPU c WHERE c.name = '...'")
    Optional<Component> findComponentByName(String name);
    List<Component> findByTypeOfComponent(String type);
}
