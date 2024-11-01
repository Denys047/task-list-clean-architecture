package com.tasklist.task_list_clean_architecture.application.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }
    
}
