package com.example.ms.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.ms.user.exception.ExceptionConstants.*;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception exception) {
        log.error("Exception", exception);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionResponse handle(NotFoundException exception) {
        log.error("NotFoundException", exception);
        return new ExceptionResponse(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse handle(MethodArgumentNotValidException exception) {
        log.error("MethodArgumentNotValidException", exception);
        return new ExceptionResponse(
                exception.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(AlreadyCreatedException.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse handle(AlreadyCreatedException ex) {
        log.error("AlreadyCreatedException: ", ex);
        return new ExceptionResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(FORBIDDEN)
    public ExceptionResponse handle(AccessDeniedException exception) {
        log.error("AccessDeniedException", exception);
        return new ExceptionResponse(ACCESS_DENIED_CODE, ACCESS_DENIED_MESSAGE);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ExceptionResponse handle(WrongCredentialsException exception) {
        log.error("WrongCredentialsException", exception);
        return new ExceptionResponse(WRONG_CREDENTIALS_CODE, WRONG_CREDENTIALS_MESSAGE);
    }

}
