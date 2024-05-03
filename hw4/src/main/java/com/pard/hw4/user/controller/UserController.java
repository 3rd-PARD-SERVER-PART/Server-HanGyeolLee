package com.pard.hw4.user.controller;


import com.pard.hw4.user.dto.loan.UserLoanDTO;
import com.pard.hw4.user.dto.user.UserCreateDTO;
import com.pard.hw4.user.dto.user.UserReadDTO;
import com.pard.hw4.user.service.UserLoanService;
import com.pard.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserLoanService userLoanService;

    @PostMapping("")
    public String createUser(@RequestBody UserCreateDTO dto){
        userService.createUser(dto);
        return "success";
    }
    @GetMapping("")
    public List<UserReadDTO> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/borrow")
    public List<UserLoanDTO> findAllLoans(){
        return userLoanService.findAll();
    }

//    @GetMapping("/loan/{userId}")
//    public List<UserReadDTO> findUserHistoryByUserId(@PathVariable("userId") Long userId) {
//        return userLoanService.findUserHistory(userId);
//    }
    @GetMapping("/borrow/{userId}")
    public List<UserLoanDTO> findUserHistoryByUserId(@PathVariable("userId") Long userId) {
        return userLoanService.findUserHistory(userId);
    }
    @PostMapping("/borrow")
    public String borrowBook(@RequestBody UserLoanDTO dto){
        System.out.println("!");
        return userLoanService.borrow(dto);
    }

    @PostMapping("/return")
    public String returnBook(@RequestBody UserLoanDTO dto){
        return userLoanService.returnBook(dto);
    }


}
