package com.pard.thirdseminar.user.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    // 필요한것만 쓴다
    private String email;
    private String password;
}
