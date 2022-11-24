package com.parcel.repository;

import com.parcel.model.domain.user.ClassUser;
import com.parcel.model.domain.user.UserAccountType;
import com.parcel.model.domain.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<ClassUser, Long> {

    List<ClassUser> findAllById(Long id);
    List<ClassUser> findAllByLogin(String login);
    List<ClassUser> findAllByEmail(String email);
    List<ClassUser> findAllByAccountType(UserAccountType accountType);
    List<ClassUser> findAllByStatus(UserStatus status);
    ClassUser findByLogin(String login);
    ClassUser findByPassword(String password);
    ClassUser findUserById(Long id);
}