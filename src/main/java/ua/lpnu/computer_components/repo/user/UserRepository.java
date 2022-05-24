package ua.lpnu.computer_components.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lpnu.computer_components.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "select u from UserEntity u where u.email = ?1")
    UserEntity findByEmail(String email);

    void deleteById(Long id);
}
