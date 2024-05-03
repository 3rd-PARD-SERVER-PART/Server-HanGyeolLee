package com.pard.hw4.user.dto.user;


import com.pard.hw4.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserReadDTO {
    private Long userId;
    private String name;
    private Integer age;
    private String major;

    public UserReadDTO(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.major = user.getMajor();
    }
}
