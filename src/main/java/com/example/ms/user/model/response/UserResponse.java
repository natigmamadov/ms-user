package com.example.ms.user.model.response;

import com.example.ms.user.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private UserType userType;
    private String photo;
}
