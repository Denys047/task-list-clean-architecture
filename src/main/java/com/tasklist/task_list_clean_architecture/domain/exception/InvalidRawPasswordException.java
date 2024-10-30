package com.tasklist.task_list_clean_architecture.domain.exception;

public class InvalidRawPasswordException extends RuntimeException {

    private static final String INVALID_RAW_PASSWORD_LENGTH_MESSAGE = "";

    private static final String INVALID_RAW_PASSWORD_NO_DIGIT_MESSAGE = "";

    private static final String INVALID_RAW_PASSWORD_NO_UPPER_CASE_MESSAGE = "";

    public InvalidRawPasswordException(String message) {
        super(message);
    }

    public static InvalidRawPasswordException invalidLength() {
        return new InvalidRawPasswordException(INVALID_RAW_PASSWORD_LENGTH_MESSAGE);
    }

    public static InvalidRawPasswordException noDigit() {
        return new InvalidRawPasswordException(INVALID_RAW_PASSWORD_NO_DIGIT_MESSAGE);
    }

    public static InvalidRawPasswordException noUpperCase() {
        return new InvalidRawPasswordException(INVALID_RAW_PASSWORD_NO_UPPER_CASE_MESSAGE);
    }

}
