package ru.matveyakulov.github.data_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.matveyakulov.github.data_api.advice.exception.UserDataCorrectException;
import ru.matveyakulov.github.data_api.advice.exception.UserNotFoundException;
import ru.matveyakulov.github.data_api.domain.User;
import ru.matveyakulov.github.data_api.domain.enums.Role;
import ru.matveyakulov.github.data_api.dto.UserAuthenticationRequestDTO;
import ru.matveyakulov.github.data_api.dto.UserDTO;
import ru.matveyakulov.github.data_api.mapper.UserMapper;
import ru.matveyakulov.github.data_api.repository.UserRepository;
import ru.matveyakulov.github.data_api.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public UserDTO createUser(UserAuthenticationRequestDTO userAuthenticationRequestDTO) {

        Optional<User> repUser = userRepository.findByEmail(userAuthenticationRequestDTO.getEmail());

        if(repUser.isPresent()){
            throw new UserDataCorrectException("Пользователь с почтой "
                    + userAuthenticationRequestDTO.getEmail() + " уже существует");
        }
        User user = new User();
        user.setEmail(userAuthenticationRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userAuthenticationRequestDTO.getPassword()));
        user.setDate_of_create(new Date());
        user.setRole(Role.ROLE_USER);
        return UserMapper.USER.userToUserDTO(userRepository.save(user));

    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не зарегистрирован / Неверный логин или пароль"));
        return UserMapper.USER.userToUserDTO(user);
    }

    @Transactional
    @Override
    public void updatePassword(Long id, String value) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с id= " + id + " не найден"));
        user.setPassword(value);
    }

    @Transactional
    @Override
    public void updateEmail(Long id, String value) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с id= " + id + " не найден"));
        user.setEmail(value);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> findAll() {
        return UserMapper.USER.listUserToListUserDTO(userRepository.findAll());
    }

}
