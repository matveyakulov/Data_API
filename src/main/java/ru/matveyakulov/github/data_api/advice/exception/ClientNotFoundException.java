package ru.matveyakulov.github.data_api.advice.exception;

import ru.matveyakulov.github.data_api.advice.exception.model.ResourceNotFoundException;

public class ClientNotFoundException extends ResourceNotFoundException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
