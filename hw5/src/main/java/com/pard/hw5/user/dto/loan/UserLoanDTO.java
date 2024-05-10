package com.pard.hw5.user.dto.loan;

import com.pard.hw5.user.dto.user.UserReadDTO;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.entity.UserLoanHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLoanDTO {
//    private Long id;
    private Long userID;
    private Long bookID;
    private boolean isReturn;


    public UserLoanDTO(UserLoanHistory userLoanHistory) {
//        this.id = userLoanHistory.getId();
        this.userID = userLoanHistory.getUser().getUserId();
        this.bookID = userLoanHistory.getBook().getBookId();
        this.isReturn = userLoanHistory.isReturn();
    }

    public UserLoanDTO() {
    }

}
