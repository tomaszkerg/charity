package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    UserEntity getFirstByEmail(String email);

    @Query(value="Select first_name from users where email = ?1",nativeQuery = true)
    String findFirstnameByEmail(String email);

    @Query(value="Select id from users where email = ?1",nativeQuery = true)
    Long findUserIdByEmail(String email);

}
