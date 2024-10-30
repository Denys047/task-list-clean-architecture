package com.tasklist.task_list_clean_architecture.infrastructure.security.password;

import com.tasklist.task_list_clean_architecture.application.interfaces.security.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PasswordHasherImpl implements PasswordHasher {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String hash(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String rawPassword, String password) {
        return passwordEncoder.matches(rawPassword, password);
    }

}
