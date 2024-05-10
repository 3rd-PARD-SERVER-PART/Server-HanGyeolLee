package com.pard.hw5.book.dto;


import com.pard.hw5.book.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReadDTO {
    private Long bookId;
    private String name;
    private boolean isLoan;

    public BookReadDTO(Book book){
        this.bookId = book.getBookId();
        this.name = book.getName();
    }
//
//    public BookReadDTO(Book book, UserDTO.Read user){
//        this.bookId = book.getBookId();
//        this.name = book.getName();
//        this.user = user;
//    }
//    public BookReadDTO(Book book, UserLoanDTO.Update loan){
//        this.bookId = book.getBookId();
//        this.loan = getLoan();
//
//    }
}
