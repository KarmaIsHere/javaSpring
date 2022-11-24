package com.parcel.service;

import com.parcel.model.api.request.CreateUserRequest;
import com.parcel.model.domain.user.ClassUser;
import com.parcel.model.domain.user.UserAccountType;
import com.parcel.model.domain.user.UserStatus;
import com.parcel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ClassUser createUser(CreateUserRequest request) {
        ClassUser user = ClassUser.builder()
                .accountType(UserAccountType.USER)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .status(UserStatus.FREE)
                .email(request.getEmail())
                .login(request.getLogin())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .salary("0")
                .build();

        return userRepository.save(user);
    }

    public List<ClassUser> fetchUsers(Long id, String login, String password, String email, UserAccountType accountType, UserStatus status) {
        if (id != null) {
            return this.userRepository.findAllById(id);
        } else if (login != null) {
            return this.userRepository.findAllByLogin(login);
        } else if (email != null) {
            return this.userRepository.findAllByEmail(email);
        } else if (password != null) {
            return this.userRepository.findAllByEmail(password);
        } else if (accountType != null) {
            return this.userRepository.findAllByAccountType(accountType);
        } else if (status != null) {
            return this.userRepository.findAllByStatus(status);
        } else {
            return this.userRepository.findAll();
        }
    }

    public ClassUser fetchUser(Long id) {
        return userRepository.findUserById(id);
    }

    public void updateUserInformation(String login, String newLogin, String newEmail, String newPassword, String newFirstName, String newLastName, String newPhoneNumber, String newSalary, UserStatus newStatus, UserAccountType newAccountType ) {
        ClassUser classUser = userRepository.findByLogin(login);
        if (newLogin != null) {
            classUser.setLogin(newLogin);
            userRepository.save(classUser);
        }
        if (newEmail != null) {
            classUser.setEmail(newEmail);
            userRepository.save(classUser);
        }
        if (newPassword != null) {
            classUser.setPassword(newPassword);
            userRepository.save(classUser);
        }
        if (newFirstName != null) {
            classUser.setFirstName(newFirstName);
            userRepository.save(classUser);
        }
        if (newLastName != null) {
            classUser.setLastName(newLastName);
            userRepository.save(classUser);
        }
        if (newPhoneNumber != null) {
            classUser.setPhoneNumber(newPhoneNumber);
            userRepository.save(classUser);
        }
        if (newSalary != null) {
            classUser.setSalary(newSalary);
            userRepository.save(classUser);
        }
        if (newStatus != null) {
            classUser.setStatus(newStatus);
            userRepository.save(classUser);
        }
        if (newAccountType != null) {
            classUser.setAccountType(newAccountType);
            userRepository.save(classUser);
        }
    }

    public void deleteUserByLogin(Long id) {
        ClassUser classUser = userRepository.findUserById(id);
        userRepository.deleteById(classUser.getId());
    }
}
