package com.example.ms.user.mapper;

import com.example.ms.user.dao.entity.UserEntity;
import com.example.ms.user.model.request.CreateUserRequest;
import com.example.ms.user.model.request.UpdateUserRequest;
import com.example.ms.user.model.response.UserResponse;

import java.time.LocalDateTime;

public enum UserMapper {
    USER_MAPPER;

    public UserEntity buildUserEntity(CreateUserRequest createUserRequest) {
        return UserEntity.builder()
                .name(createUserRequest.getName())
                .surname(createUserRequest.getSurname())
                .birthdate(createUserRequest.getBirthdate())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .userType(createUserRequest.getUserType())
                .photo(createUserRequest.getPhoto())
                .build();
    }

    public UserResponse buildUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .birthdate(userEntity.getBirthdate())
                .userType(userEntity.getUserType())
                .photo(userEntity.getPhoto())
                .build();
    }

    public void buildUserEntityFromUpdateUserRequest(UserEntity userEntity, UpdateUserRequest updateUserRequest) {
        userEntity.setName(updateUserRequest.getName());
        userEntity.setSurname(updateUserRequest.getSurname());
        userEntity.setBirthdate(updateUserRequest.getBirthdate());
        userEntity.setUserType(updateUserRequest.getUserType());
        userEntity.setUpdatedOn(LocalDateTime.now());
    }


}
