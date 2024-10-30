package com.tasklist.task_list_clean_architecture.application.service.usercase.user;

import com.tasklist.task_list_clean_architecture.application.consts.Role;
import com.tasklist.task_list_clean_architecture.application.dto.request.RegisterUserDto;
import com.tasklist.task_list_clean_architecture.application.exception.InvalidRepeatablePasswordException;
import com.tasklist.task_list_clean_architecture.application.exception.UsernameAlreadyExistException;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.application.interfaces.security.PasswordHasher;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import com.tasklist.task_list_clean_architecture.domain.vo.Password;
import com.tasklist.task_list_clean_architecture.domain.vo.RawPassword;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final UserDao userDao;

    private final PasswordHasher passwordHasher;

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
                new Password(passwordHasher.hash(rawPassword.getRawPassword())),
                Role.ROLE_USER.name(),
                new ArrayList<>()
        ));
    }

}
