package com.tasklist.task_list_clean_architecture.application.exception;

public class InvalidRepeatablePasswordException extends RuntimeException {

    private static final String INVALID_REPEATABLE_PASSWORD_MESSAGE = "These passwords do not match. Try again.";

    public InvalidRepeatablePasswordException() {
        super(INVALID_REPEATABLE_PASSWORD_MESSAGE);
    }

}
