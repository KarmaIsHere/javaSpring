package com.parcel.controller;

import com.parcel.model.api.request.CreateUserRequest;
import com.parcel.model.api.response.UserResponse;
import com.parcel.model.domain.user.UserAccountType;
import com.parcel.model.domain.user.UserStatus;
import com.parcel.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/registration")
    @Operation(summary = "Create new user in database")
    public Long createUser(@Validated @RequestBody CreateUserRequest request) {
        return userService.createUser(request).getId();
    }

    @GetMapping(value = "/users")
    @Operation(summary = "Get users from database")
    public List<UserResponse> fetchUsers(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) String login,
                                         @RequestParam(required = false) String password,
                                         @RequestParam(required = false) String email,
                                         @RequestParam(required = false) UserAccountType accountType,
                                         @RequestParam(required = false) UserStatus status,
                                         @RequestParam(required = false) String firstName,
                                         @RequestParam(required = false) String lastName,
                                         @RequestParam(required = false) String phoneNumber,
                                         @RequestParam(required = false) String salary) {
        return userService.fetchUsers(id, login, password, email, accountType, status, firstName, lastName, phoneNumber, salary).stream()
                .map(p -> new UserResponse(p.getId(), p.getAccountType(), p.getFirstName(), p.getLastName(), p.getStatus(), p.getEmail(), p.getLogin(), p.getPassword(), p.getPhoneNumber(), p.getSalary()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update user information")
    public void updateUserLogin(@RequestParam String login,
                                @RequestParam(required = false) String Login,
                                @RequestParam(required = false) String Email,
                                @RequestParam(required = false) String Password,
                                @RequestParam(required = false) String FirstName,
                                @RequestParam(required = false) String LastName,
                                @RequestParam(required = false) String PhoneNumber,
                                @RequestParam(required = false) String Salary,
                                @RequestParam(required = false) UserStatus Status,
                                @RequestParam(required = false) UserAccountType AccountType) {
        this.userService.updateUserInformation(login, Login, Email, Password, FirstName, LastName, PhoneNumber, Salary, Status, AccountType);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete user from database")
    public ResponseEntity<Void> deleteUserByLogin(@RequestParam Long id) {
        userService.deleteUserByLogin(id);
        return ResponseEntity.noContent().build();
    }

}