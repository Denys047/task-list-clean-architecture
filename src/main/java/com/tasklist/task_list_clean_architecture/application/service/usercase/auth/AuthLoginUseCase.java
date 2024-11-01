package com.tasklist.task_list_clean_architecture.application.service.usercase.auth;

import com.tasklist.task_list_clean_architecture.application.dto.request.LoginUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.JwtResponse;
import com.tasklist.task_list_clean_architecture.application.interfaces.security.DomainUseDetails;
import com.tasklist.task_list_clean_architecture.application.interfaces.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class AuthLoginUseCase {

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    public JwtResponse handle(LoginUserDto loginUserDto) {
        var authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginUserDto.getUsername(),
                                loginUserDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var accessToken = tokenProvider.generateToken(authentication);
        var userDetails = (DomainUseDetails) authentication;

        return new JwtResponse(userDetails.getUserModelId(), userDetails.getUsername(), accessToken, null);
    }

}
