package ua.lpnu.computer_components.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lpnu.computer_components.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "select u from UserEntity u where u.email = ?1")
    UserEntity findByEmail(String email);

    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "update UserEntity u set u.password = ?2 where u.email = ?1")
    void updatePassword(String email, String password);
}
