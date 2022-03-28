package ru.matveyakulov.github.data_api.advice.exception;

import ru.matveyakulov.github.data_api.advice.exception.model.ResourceNotFoundException;

public class OrderNotFoundException extends ResourceNotFoundException {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
