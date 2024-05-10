package com.pard.hw5.book.controller;

import com.pard.hw5.book.dto.BookCreateDTO;
import com.pard.hw5.book.dto.BookReadDTO;
import com.pard.hw5.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    // 책 생성
    @PostMapping("")
    public String createBook(@RequestBody BookCreateDTO dto) {
        bookService.createBook(dto);
        return "Success";
    }


    // 책 출력하기
    @GetMapping("")
    public List<BookReadDTO> findAll (){
        return bookService.findAll();
    }
}
