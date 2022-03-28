package ru.matveyakulov.github.data_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import ru.matveyakulov.github.data_api.advice.exception.JwtAuthenticationException;
import ru.matveyakulov.github.data_api.dto.UserAuthenticationRequestDTO;
import ru.matveyakulov.github.data_api.security.jwt.JwtTokenProvider;
import ru.matveyakulov.github.data_api.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAuthenticationRequestDTO request) {

        userService.createUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authenticate(@RequestBody UserAuthenticationRequestDTO request) {
        try {

            String token = jwtTokenProvider.createToken(request);
            Map<Object, Object> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {

            throw new JwtAuthenticationException("Неверный логин или пароль");
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, null);
    }
}
