package com.tasklist.task_list_clean_architecture.presentation.api;

import com.tasklist.task_list_clean_architecture.application.dto.request.LoginUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.request.RegisterUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.ApiResponse;
import com.tasklist.task_list_clean_architecture.application.dto.response.JwtResponse;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadUserDto;
import com.tasklist.task_list_clean_architecture.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<ReadUserDto>> register(@RequestBody RegisterUserDto registerUserDto) {
        var result = authService.register(registerUserDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(List.of(
                        new ReadUserDto(result.getId().toString(), result.getName(), result.getUsername())
                )));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtResponse>> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        List.of(authService.login(loginUserDto))
                )
        );
    }

}
