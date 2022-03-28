package ru.matveyakulov.github.data_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matveyakulov.github.data_api.domain.User;
import ru.matveyakulov.github.data_api.dto.UserDTO;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
    User getByEmail(String email);
}
