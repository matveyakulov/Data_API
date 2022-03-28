package ru.matveyakulov.github.data_api.advice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.matveyakulov.github.data_api.advice.exception.model.DataCorrectException;
import ru.matveyakulov.github.data_api.advice.exception.model.ResourceNotFoundException;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class BaseAdviceController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Object resourceNotFoundHandle(ResourceNotFoundException ex){
        return response(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(DataCorrectException.class)
    public Object dataCorrectHandle(DataCorrectException ex){
        return response(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(AuthenticationException.class)
    public Object jwtExceptionHandle(AuthenticationException ex){
        return response(HttpStatus.FORBIDDEN, ex);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Object accessDeniedExceptionHandle(AccessDeniedException ex){
        return response(HttpStatus.FORBIDDEN, ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Object validExceptionHandle(ConstraintViolationException ex){
        return response(HttpStatus.FORBIDDEN, ex);
    }

    private Object response(HttpStatus status, Throwable ex){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("message", ex.getMessage());
        body.put("timestamp", new Date().toString());

        return new ResponseEntity<>(body, httpHeaders, status);
    }
}
