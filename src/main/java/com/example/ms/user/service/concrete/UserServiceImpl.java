package com.example.ms.user.service.concrete;

import com.example.ms.user.annotation.LogAnnotation;
import com.example.ms.user.dao.entity.UserEntity;
import com.example.ms.user.dao.repository.UserRepository;
import com.example.ms.user.exception.NotFoundException;
import com.example.ms.user.model.request.UpdateUserRequest;
import com.example.ms.user.model.response.UserResponse;
import com.example.ms.user.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.user.exception.ExceptionConstants.USER_NOT_FOUND_BY_ID_MESSAGE;
import static com.example.ms.user.exception.ExceptionConstants.USER_NOT_FOUND_CODE;
import static com.example.ms.user.mapper.UserMapper.USER_MAPPER;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    @LogAnnotation
    public UserResponse getUserById(Long id) {
        var userEntity = fetchUserByIdIfExists(id);
        return USER_MAPPER.buildUserResponse(userEntity);
    }

    @Override
    @LogAnnotation
    public void updateUser(Long id, UpdateUserRequest updateUserRequest) {
        var userEntity = fetchUserByIdIfExists(id);
        USER_MAPPER.buildUserEntityFromUpdateUserRequest(userEntity,updateUserRequest);
        userRepository.save(userEntity);
    }

    public UserEntity fetchUserByIdIfExists(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(USER_NOT_FOUND_CODE,
                                String.format(USER_NOT_FOUND_BY_ID_MESSAGE,id)));
    }
}
