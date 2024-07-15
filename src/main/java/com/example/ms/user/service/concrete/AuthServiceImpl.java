package com.example.ms.user.service.concrete;

import com.example.ms.user.annotation.LogAnnotation;
import com.example.ms.user.dao.repository.UserRepository;
import com.example.ms.user.exception.AlreadyCreatedException;
import com.example.ms.user.exception.NotFoundException;
import com.example.ms.user.exception.WrongCredentialsException;
import com.example.ms.user.model.request.AuthRequest;
import com.example.ms.user.model.request.CreateUserRequest;
import com.example.ms.user.service.abstraction.AuthService;
import com.example.ms.user.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.user.exception.ExceptionConstants.*;
import static com.example.ms.user.mapper.UserMapper.USER_MAPPER;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthUtil authUtil;


    @Override
    @LogAnnotation
    public void createUser(CreateUserRequest createUserRequest) {
        String email = createUserRequest.getEmail();
        createUserRequest.setPassword(authUtil.hashPassword(createUserRequest.getPassword()));
        userRepository.findByEmail(email).ifPresent(
                userEntity -> {
                    throw new AlreadyCreatedException(
                            EMAIL_ALREADY_REGISTERED_CODE,
                            String.format(EMAIL_ALREADY_REGISTERED_MESSAGE, email));
                });
        userRepository.save(USER_MAPPER.buildUserEntity(createUserRequest));
    }

    @Override
    @LogAnnotation
    public void authUser(AuthRequest authRequest) {
        String email = authRequest.getEmail();
        userRepository.findByEmail(email)
                .ifPresentOrElse(userEntity -> {
                    if (!authUtil.verifyPassword(authRequest.getPassword(), userEntity.getPassword())) {
                        throw new WrongCredentialsException(WRONG_CREDENTIALS_CODE,
                                WRONG_CREDENTIALS_MESSAGE);
                    }
                }, () -> {
                    throw new NotFoundException(USER_NOT_FOUND_CODE,
                            String.format(USER_NOT_FOUND_BY_EMAIL_MESSAGE, email));
                });

    }

}
