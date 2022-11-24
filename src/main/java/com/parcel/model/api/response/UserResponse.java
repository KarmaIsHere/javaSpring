package com.parcel.model.api.response;

import com.parcel.model.domain.user.UserAccountType;
import com.parcel.model.domain.user.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    @Schema(description = "User id", example = "1")
    private Long id;

    @Schema(description = "User working accountType", example = "Manager")
    private UserAccountType accountType;

    @Schema(description = "User first name", example = "Freddie")
    private String firstName;

    @Schema(description = "User last name", example = "Mercury")
    private String lastName;

    @Schema(description = "User working status", example = "WORKING")
    private UserStatus status;

    @Schema(description = "User email", example = "test@gmail.com")
    private String email;

    @Schema(description = "User login", example = "user123")
    private String login;

    @Schema(description = "User password", example = "123")
    private String password;

    @Schema(description = "User phone number", example = "731-285-9170")
    private String phoneNumber;

    @Schema(description = "User salary", example = "100000")
    private String salary;

}