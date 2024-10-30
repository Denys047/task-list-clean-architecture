package com.tasklist.task_list_clean_architecture.infrastructure.security.user;

import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.UserOrm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserOrm userOrm;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userOrm
                .findByUsername(username)
                .map(SecurityUserModel::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

}
