package ru.matveyakulov.github.data_api.advice.exception;

import ru.matveyakulov.github.data_api.advice.exception.model.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
