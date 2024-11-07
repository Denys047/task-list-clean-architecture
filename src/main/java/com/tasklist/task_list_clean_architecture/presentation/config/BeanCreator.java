package com.tasklist.task_list_clean_architecture.presentation.config;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.application.interfaces.security.TokenProvider;
import com.tasklist.task_list_clean_architecture.application.service.AuthService;
import com.tasklist.task_list_clean_architecture.application.service.TaskService;
import com.tasklist.task_list_clean_architecture.application.service.UserService;
import com.tasklist.task_list_clean_architecture.application.service.usercase.auth.AuthLoginUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.auth.AuthRegisterUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.*;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.DeleteUserUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.GetByIdUserUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.IsTaskOwnerUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.UpdateUserUseCase;
import com.tasklist.task_list_clean_architecture.infrastructure.database.impl.TaskDaoImp;
import com.tasklist.task_list_clean_architecture.infrastructure.database.impl.UserDaoIml;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.TaskOrm;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.UserOrm;
import com.tasklist.task_list_clean_architecture.infrastructure.security.filter.BearerAuthConverter;
import com.tasklist.task_list_clean_architecture.infrastructure.security.filter.JwsTokenFilter;
import com.tasklist.task_list_clean_architecture.infrastructure.security.token.JwsTokenProvider;
import com.tasklist.task_list_clean_architecture.infrastructure.security.user.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanCreator {

    @Bean
    public TaskDao taskDao(TaskOrm taskOrm) {
        return new TaskDaoImp(taskOrm);
    }

    @Bean
    public UserDao userDao(UserOrm userOrm) {
        return new UserDaoIml(userOrm);
    }

    @Bean
    public UserService userService(UserDao userDao) {
        return new UserService(
                new GetByIdUserUseCase(userDao),
                new IsTaskOwnerUseCase(userDao),
                new UpdateUserUseCase(userDao),
                new DeleteUserUseCase(userDao)
        );
    }

    @Bean
    public TaskService taskService(TaskDao taskDao) {
        return new TaskService(
                new CreateTaskUseCase(taskDao),
                new GetByIdTaskUseCase(taskDao),
                new GetAllTaskByUserId(taskDao),
                new UpdateTaskUseCase(taskDao),
                new DeleteTaskUseCase(taskDao)
        );
    }

    @Bean
    public AuthService authService(UserDao userDao, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        return new AuthService(
                new AuthRegisterUseCase(userDao, passwordEncoder),
                new AuthLoginUseCase(tokenProvider(), authenticationManager)
        );
    }

    @Bean
    public UserDetailsService userDetailsService(UserOrm userOrm) {
        return new UserDetailsServiceImpl(userOrm);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenProvider tokenProvider() {
        return new JwsTokenProvider();
    }

    @Bean
    public BearerAuthConverter authenticationConverter(TokenProvider tokenProvider, UserDetailsService userDetailsService) {
        return new BearerAuthConverter(tokenProvider, userDetailsService);
    }

    @Bean
    public JwsTokenFilter oncePerRequestFilter(BearerAuthConverter bearerAuthConverter) {
        return new JwsTokenFilter(bearerAuthConverter);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService) {
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
