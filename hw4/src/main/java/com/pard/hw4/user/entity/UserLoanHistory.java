package com.pard.hw4.user.entity;

import com.pard.hw4.user.dto.loan.UserLoanDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import com.pard.hw4.book.entity.Book;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false ,name = "book_id")
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

    public static UserLoanHistory toEntity(UserLoanDTO dto, User user, Book book) {
        return UserLoanHistory.builder()
//                .id(dto.getId())
                .user(user)
                .book(book)
                .isReturn(dto.isReturn())
                .build();
    }
}
