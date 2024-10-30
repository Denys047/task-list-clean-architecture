package com.tasklist.task_list_clean_architecture.domain.exception;

public class InvalidRawPasswordException extends RuntimeException {

    private static final String INVALID_RAW_PASSWORD_LENGTH_MESSAGE = "Password must be between 7 and 64 characters.";

    private static final String INVALID_RAW_PASSWORD_NO_DIGIT_MESSAGE = "No digit in value.";

    private static final String INVALID_RAW_PASSWORD_NO_UPPER_CASE_MESSAGE = "No upper case character in value.";

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
