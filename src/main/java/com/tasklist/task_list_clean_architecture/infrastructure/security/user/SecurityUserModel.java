package com.tasklist.task_list_clean_architecture.infrastructure.security.user;

import com.tasklist.task_list_clean_architecture.infrastructure.database.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class SecurityUserModel implements UserDetails {

    private final UserModel userModel;

    @Override
    public String getUsername() {
        return userModel.getUsername();
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userModel.getRole().name()));
    }

}
