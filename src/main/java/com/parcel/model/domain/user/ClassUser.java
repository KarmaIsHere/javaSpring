package com.parcel.model.domain.user;

import com.parcel.model.domain.forum.ClassComment;
import com.parcel.model.domain.order.ClassTrip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(name = "ACCOUNT_TYPE")
    private UserAccountType accountType;

    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 20)
    private String lastName;

    @Column(name = "STATUS")
    private UserStatus status;

    @Column(name = "EMAIL", nullable = false, length = 30, unique = true)
    private String email;

    @Column(name = "LOGIN", nullable = false, length = 20, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "PHONE_NUMBER", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "SALARY", nullable = false)
    private String salary;

    @OneToMany(mappedBy = "driver")
    private List<ClassTrip> trips;

    @OneToMany(mappedBy = "manager")
    private List<ClassTrip> tripss;

    @OneToMany(mappedBy = "user")
    private List<ClassComment> comments;

    @OneToMany(mappedBy = "user")
    private List<ClassComment> forums;
}
