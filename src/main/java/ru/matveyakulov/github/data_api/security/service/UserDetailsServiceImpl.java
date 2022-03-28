package ru.matveyakulov.github.data_api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.matveyakulov.github.data_api.advice.exception.UserNotFoundException;
import ru.matveyakulov.github.data_api.domain.User;
import ru.matveyakulov.github.data_api.repository.UserRepository;
import ru.matveyakulov.github.data_api.security.model.SecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {

        User user = userRepository.getByEmail(email);
        return new SecurityUser(user);
    }
}
