package com.example.ms.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private String code;

    public NotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
}
