package ru.matveyakulov.github.data_api.advice.exception.model;

public abstract class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
