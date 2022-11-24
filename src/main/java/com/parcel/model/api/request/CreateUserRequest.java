package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User first name", example = "Freddie")
    private String firstName;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User last name", example = "Mercury")
    private String lastName;
    @NonNull
    @Schema(description = "User email", example = "test@gmail.com")
    private String email;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User login", example = "user123")
    private String login;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User Password", example = "123")
    private String password;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User phone number", example = "731-285-9170")
    private String phoneNumber;
}