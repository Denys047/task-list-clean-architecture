package com.tasklist.task_list_clean_architecture.application.interfaces.security;

import org.springframework.security.core.Authentication;

public interface TokenProvider {

    String generateToken(Authentication authentication);

    boolean validateToken(String token);

}
