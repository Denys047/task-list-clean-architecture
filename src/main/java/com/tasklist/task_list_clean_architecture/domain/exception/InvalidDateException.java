package com.tasklist.task_list_clean_architecture.domain.exception;

public class InvalidDateException extends RuntimeException {

    private static final String INVALID_DATE_MESSAGE = "The start date must be before the end date.";

    public InvalidDateException() {
        super(INVALID_DATE_MESSAGE);
    }

}
