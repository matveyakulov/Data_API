package ru.matveyakulov.github.data_api.advice.exception;

import ru.matveyakulov.github.data_api.advice.exception.model.DataCorrectException;

public class UserDataCorrectException extends DataCorrectException {

    public UserDataCorrectException(String message) {
        super(message);
    }
}
