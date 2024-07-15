package com.example.ms.user.model.request;

import com.example.ms.user.model.enums.UserType;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private UserType userType;
    private String photo;
}
