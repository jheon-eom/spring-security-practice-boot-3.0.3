package com.security.practice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userId;
    @Column
    private String password;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Role roles;

    public Member(String userId, String password, Role roles) {
        this.userId = userId;
        this.password = password;
        this.roles = roles;
    }

    public static Member createUser(String userId, String password) {
        return new Member(userId, password, Role.USER);
    }

}
