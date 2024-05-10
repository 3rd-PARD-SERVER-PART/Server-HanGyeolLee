package com.pard.hw5.book.entity;

import com.pard.hw5.book.dto.BookCreateDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ColumnDefault("0")
    private boolean isLoan;


    public void setLoan(boolean data) {
        isLoan = data;
    }

    public static Book toEntity(BookCreateDTO dto) {
        return Book.builder()
//                .bookId(dto.getBookId())
                .name(dto.getName())
                .isLoan(false)
                .build();
    }

}
