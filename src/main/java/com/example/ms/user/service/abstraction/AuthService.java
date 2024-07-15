package com.example.ms.user.service.abstraction;

import com.example.ms.user.model.request.AuthRequest;
import com.example.ms.user.model.request.CreateUserRequest;

public interface AuthService {
    void createUser(CreateUserRequest createUserRequest);

    void authUser(AuthRequest authRequest);

}
