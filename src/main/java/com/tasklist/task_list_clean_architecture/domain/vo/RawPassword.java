package com.tasklist.task_list_clean_architecture.domain.vo;

import com.tasklist.task_list_clean_architecture.domain.exception.InvalidRawPasswordException;

public class RawPassword {

    private final String rawPassword;

    public RawPassword(String rawPassword) {
        validateRawPassword(rawPassword);
        this.rawPassword = rawPassword;
    }

    private void validateRawPassword(String rawPassword) {
        if (rawPassword.length() < 4) {
            throw InvalidRawPasswordException.invalidLength();
        }

        if (rawPassword.chars().noneMatch(Character::isDigit)) {
            throw InvalidRawPasswordException.noDigit();
        }

        if (rawPassword.chars().noneMatch(Character::isUpperCase)) {
            throw InvalidRawPasswordException.noUpperCase();
        }
    }

    public String getRawPassword() {
        return rawPassword;
    }

}
