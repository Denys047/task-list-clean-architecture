package com.tasklist.task_list_clean_architecture.domain.exception;

public class InvalidIdException extends RuntimeException {

    private static final String INVALID_ID_MESSAGE = "id cannot be null";

    public InvalidIdException() {
        super(INVALID_ID_MESSAGE);
    }

}
