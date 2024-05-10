package com.pard.hw5.user.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private String name;
    private Integer age;
    private String major;
    private String email;

    public UserCreateDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
