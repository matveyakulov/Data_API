package ru.matveyakulov.github.data_api.service;

import ru.matveyakulov.github.data_api.dto.UserAuthenticationRequestDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserAuthenticationRequestDTO userAuthenticationRequestDTO);
    UserDTO findByEmailAndPassword(String email, String password);

    void updatePassword(Long id, String value);

    void updateEmail(Long id, String value);

    List<UserDTO> findAll();
}
