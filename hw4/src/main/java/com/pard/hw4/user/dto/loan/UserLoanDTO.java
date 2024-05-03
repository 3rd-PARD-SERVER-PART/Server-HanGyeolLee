package com.pard.hw4.user.dto.loan;

import com.pard.hw4.user.entity.UserLoanHistory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoanDTO {
    private Long id;
    private Long userID;
    private Long bookID;
    private boolean isReturn;


    public UserLoanDTO(UserLoanHistory userLoanHistory) {
        this.id = userLoanHistory.getId();
        this.userID = userLoanHistory.getUser().getUserId();
        this.bookID = userLoanHistory.getBook().getBookId();
        this.isReturn = userLoanHistory.isReturn();
    }

    public UserLoanDTO() {
    }



}
