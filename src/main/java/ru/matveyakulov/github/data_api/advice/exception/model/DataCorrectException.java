package ru.matveyakulov.github.data_api.advice.exception.model;

public abstract class DataCorrectException extends RuntimeException{

    public DataCorrectException(String message) {
        super(message);
    }
}
