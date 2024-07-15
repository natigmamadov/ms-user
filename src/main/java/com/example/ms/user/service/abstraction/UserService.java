package com.example.ms.user.service.abstraction;

import com.example.ms.user.model.request.AuthRequest;
import com.example.ms.user.model.request.CreateUserRequest;
import com.example.ms.user.model.request.UpdateUserRequest;
import com.example.ms.user.model.response.UserResponse;

public interface UserService {

    UserResponse getUserById(Long id);

    void updateUser(Long id, UpdateUserRequest updateUserRequest);

}
