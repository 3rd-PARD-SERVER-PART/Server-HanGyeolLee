package org.example.pard.member.dto;

import lombok.Getter;

@Getter
public class MemberCreateDTO {
// Create DTO -> 유저 생성용 DTO

    // id 는 자동 지정됨
    private String name;
    private String part;
    private int age;

}
