package com.pard.thirdseminar.user.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userId; // 프라이머리 키?

    @Column(name = "email", length = 20) // 컬럼 이름은 이메일 길이는 최대 20
    private String userEmail;

    @Column(name = "password") // 컬럼 이름은 패스워드
    private String userPassword;

    @CreationTimestamp // 기본적으로 주는 어노테이션 저장될때 자동
    private Timestamp userSignupTime;

}
