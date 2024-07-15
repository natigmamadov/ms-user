package com.example.ms.user.exception;

public interface ExceptionConstants {
    String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    String USER_NOT_FOUND_CODE = "USER_NOT_FOUND";
    String USER_NOT_FOUND_BY_ID_MESSAGE = "USER with id: %s not found";
    String USER_NOT_FOUND_BY_EMAIL_MESSAGE = "User with email: %s not found";

    String  ACCESS_DENIED_CODE = "ACCESS_DENIED";
    String  ACCESS_DENIED_MESSAGE = "User doesn't have access for this operation!";

    String  WRONG_CREDENTIALS_CODE = "WRONG_CREDENTIALS";
    String  WRONG_CREDENTIALS_MESSAGE = "User doesn't match with given credentials!";

    String  EMAIL_ALREADY_REGISTERED_CODE = "EMAIL_ALREADY_REGISTERED";
    String  EMAIL_ALREADY_REGISTERED_MESSAGE = "User with email: %s is already registered";
}
