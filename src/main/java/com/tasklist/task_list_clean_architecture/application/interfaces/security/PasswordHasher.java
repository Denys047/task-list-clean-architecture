package com.tasklist.task_list_clean_architecture.application.interfaces.security;

public interface PasswordHasher {

    String hash(String password);

    boolean matches(String rawPassword, String password);

}
