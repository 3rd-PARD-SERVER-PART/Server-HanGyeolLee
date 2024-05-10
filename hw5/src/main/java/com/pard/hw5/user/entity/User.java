package com.pard.hw5.user.entity;

import com.pard.hw5.user.dto.user.UserCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String major;

    private Integer age;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();


    public static User toEntity(UserCreateDTO dto) {
        return User.builder()
                .name(dto.getName())
                .major(dto.getMajor())
                .age(dto.getAge())
                .email(dto.getEmail())
//                .userLoanHistorie s(dto.get)
                .build();
    }
//    public static User toEntity(UserCreateDTO dto) {
//        return User.builder()
//                .name(dto.getName())
//                .major(dto.getMajor())
//                .age(dto.getAge())
////                .userLoanHistorie s(dto.get)
//                .build();
//    }
}
