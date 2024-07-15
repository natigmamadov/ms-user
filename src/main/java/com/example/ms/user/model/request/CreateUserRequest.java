package com.example.ms.user.model.request;

import com.example.ms.user.model.constants.ApplicationConstants;
import com.example.ms.user.model.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.example.ms.user.model.constants.ApplicationConstants.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = NAME_IS_REQUIRED)
    private String name;

    @NotBlank(message =SURNAME_IS_REQUIRED)
    private String surname;

    private LocalDate birthdate;

    @NotBlank(message = EMAIL_IS_REQUIRED)
    @Email(message = EMAIL_IS_NOT_VALID)
    private String email;

    @NotBlank(message = PASSWORD_IS_REQUIRED)
    private String password;

    @NotNull(message = USER_TYPE_ID_IS_REQUIRED)
    private UserType userType;

    private String photo;
}
