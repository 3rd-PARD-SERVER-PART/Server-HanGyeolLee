package com.pard.hw4.user.service;

import com.pard.hw4.user.dto.user.UserCreateDTO;
import com.pard.hw4.user.dto.user.UserReadDTO;
import com.pard.hw4.user.entity.User;
import com.pard.hw4.user.repo.UserRepo;
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
                .map(user -> new UserReadDTO(user))
                .collect(Collectors.toList());
    }
}
