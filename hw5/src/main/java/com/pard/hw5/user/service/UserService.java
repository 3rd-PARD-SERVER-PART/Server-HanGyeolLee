package com.pard.hw5.user.service;

import com.pard.hw5.user.dto.loan.UserLoanDTO;
import com.pard.hw5.user.dto.user.UserCreateDTO;
import com.pard.hw5.user.dto.user.UserReadDTO;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserCreateDTO dto) {
        userRepo.save(User.toEntity(dto));
    }

    public List<UserReadDTO> findAll() {
        return userRepo.findAll()
                .stream()
                .map(user -> new UserReadDTO(user,
                        user.getUserLoanHistories()
                                .stream()
                                .map(UserLoanDTO::new)
                                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
