package com.pard.hw4.user.service;


import com.pard.hw4.book.entity.Book;
import com.pard.hw4.book.repo.BookRepo;
import com.pard.hw4.user.dto.loan.UserLoanDTO;
import com.pard.hw4.user.dto.user.UserCreateDTO;
import com.pard.hw4.user.entity.UserLoanHistory;
import com.pard.hw4.user.repo.UserLoanRepo;
import com.pard.hw4.user.repo.UserRepo;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserLoanService {
    private final UserLoanRepo userLoanRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public void createLoan(UserLoanDTO dto) {
        userLoanRepo.save(
                UserLoanHistory.toEntity(
                        dto,
                        userRepo.findById(dto.getUserID()).get(),
                        bookRepo.findById(dto.getBookID()).get()
                )
        );
    }

    public void updateBookLoanData(UserLoanDTO dto, boolean isLoan) {
        Book book = bookRepo.findById(dto.getBookID()).orElseThrow();
        book.setLoan(isLoan);
        bookRepo.save(book);
    }


    public String borrow(UserLoanDTO dto) {
        if (!isLoaned(dto)) { // 대여 가능
            updateBookLoanData(dto, true);
            createLoan(dto);
            return "success";
        } else { // 대여 불가능
            return "fail : isLoaned";
        }
    }

    public String returnBook(UserLoanDTO dto) {
        if (isLoaned(dto)) { // 반납 가능
            updateBookLoanData(dto, false);
            updtaeLoan(dto, true);
            return "success";
        } else { // 대여 불가능
            return "fail : is not Loaned";
        }
    }


    public void updtaeLoan(UserLoanDTO dto, boolean isLoan) {
        dto.setReturn(isLoan);
        userLoanRepo.save(
                UserLoanHistory.toEntity(
                        dto,
                        userRepo.findById(dto.getUserID()).get(),
                        bookRepo.findById(dto.getBookID()).get()
                )
        );
    }


    public boolean isLoaned(UserLoanDTO dto) {
        return bookRepo.findById(dto.getBookID()).get().isLoan();
    }

    public List<UserLoanDTO> findAll() {
        return userLoanRepo.findAll()
                .stream()
                .map(userLoanHistory -> new UserLoanDTO(userLoanHistory))
                .collect(Collectors.toList());
    }

    public List<UserLoanDTO> findUserHistory(Long userID) {
        List<UserLoanHistory> temp = userLoanRepo.findByUserUserId(userID);

        List<UserLoanDTO> userLoanDTOs = temp.stream()
                .map(UserLoanDTO::new)
                .collect(Collectors.toList());
//        List<UserLoanDTO> userLoanDTOs = temp.stream()
//                .map(userLoanHistory -> {
//                    return new UserLoanDTO(userLoanHistory);
//                })
//                .collect(Collectors.toList());
        return userLoanDTOs;
    }

}
