package com.pard.hw4.book.service;

import com.pard.hw4.book.dto.BookCreateDTO;
import com.pard.hw4.book.dto.BookReadDTO;
import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public void createBook(BookCreateDTO dto) {
        bookRepo.save(Book.toEntity(dto));
    }

    public List<BookReadDTO> findAll() {
        return bookRepo.findAll()
                .stream()
                .map(book -> new BookReadDTO(book))
                .collect(Collectors.toList());
    }
}
