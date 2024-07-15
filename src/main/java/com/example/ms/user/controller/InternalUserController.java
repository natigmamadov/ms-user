package com.example.ms.user.controller;

import com.example.ms.user.model.request.AuthRequest;
import com.example.ms.user.model.request.CreateUserRequest;
import com.example.ms.user.service.abstraction.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("internal/v1/users")
@RequiredArgsConstructor
public class InternalUserController {
    private final AuthService securityService;

    @PostMapping("/sign-up")
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        securityService.createUser(createUserRequest);
    }

    @PostMapping("/sign-in")
    @ResponseStatus(NO_CONTENT)
    public void authUser(@RequestBody AuthRequest authRequest) {
        securityService.authUser(authRequest);
    }
}
