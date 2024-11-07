package com.tasklist.task_list_clean_architecture.application.service.usercase.auth;

import com.tasklist.task_list_clean_architecture.application.consts.Role;
import com.tasklist.task_list_clean_architecture.application.dto.request.RegisterUserDto;
import com.tasklist.task_list_clean_architecture.application.exception.InvalidRepeatablePasswordException;
import com.tasklist.task_list_clean_architecture.application.exception.UsernameAlreadyExistException;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import com.tasklist.task_list_clean_architecture.domain.vo.Password;
import com.tasklist.task_list_clean_architecture.domain.vo.RawPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@RequiredArgsConstructor
public class AuthRegisterUseCase {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    public User handle(RegisterUserDto registerUserDto) {
        if (!registerUserDto.getPassword().equals(registerUserDto.getRepeatablePassword())) {
            throw new InvalidRepeatablePasswordException();
        }

        if (userDao.existByUsername(registerUserDto.getUsername())) {
            throw new UsernameAlreadyExistException();
        }

        RawPassword rawPassword = new RawPassword(registerUserDto.getPassword());

        return userDao.create(new User(
                new Id(),
                registerUserDto.getName(),
                registerUserDto.getUsername(),
                new Password(passwordEncoder.encode(rawPassword.getRawPassword())),
                Role.ROLE_USER.name(),
                new ArrayList<>()
        ));
    }

}
