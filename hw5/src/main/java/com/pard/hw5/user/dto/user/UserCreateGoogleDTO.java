package com.pard.hw5.user.dto.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateGoogleDTO {
    private String name;
    private String email;

    public UserCreateGoogleDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
