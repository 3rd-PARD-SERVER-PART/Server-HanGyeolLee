package com.pard.hw5.user.dto.user;


import com.pard.hw5.user.dto.loan.UserLoanDTO;
import com.pard.hw5.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
//@Builder
public class UserReadDTO {
    private Long userId;
    private String name;
    private Integer age;
    private String major;
    private List<UserLoanDTO> userLoanHistories;

    public UserReadDTO(User user, List<UserLoanDTO> history) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.major = user.getMajor();
        this.userLoanHistories = history;
    }
}
