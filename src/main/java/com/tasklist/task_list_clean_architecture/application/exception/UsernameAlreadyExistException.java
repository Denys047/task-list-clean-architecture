package com.tasklist.task_list_clean_architecture.application.exception;

public class UsernameAlreadyExistException extends RuntimeException {

  private static final String USERNAME_ALREADY_EXIST_MESSAGE = "This username already in use.";

    public UsernameAlreadyExistException() {
        super(USERNAME_ALREADY_EXIST_MESSAGE);
    }

}
