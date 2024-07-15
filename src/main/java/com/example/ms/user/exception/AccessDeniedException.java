package com.example.ms.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessDeniedException extends RuntimeException {
    private String code;

    public AccessDeniedException(String code, String message) {
        super(message);
        this.code = code;
    }
}
