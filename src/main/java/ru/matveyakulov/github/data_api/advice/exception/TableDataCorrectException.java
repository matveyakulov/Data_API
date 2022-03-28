package ru.matveyakulov.github.data_api.advice.exception;

import ru.matveyakulov.github.data_api.advice.exception.model.DataCorrectException;

public class TableDataCorrectException extends DataCorrectException {

    public TableDataCorrectException(String message) {
        super(message);
    }
}
