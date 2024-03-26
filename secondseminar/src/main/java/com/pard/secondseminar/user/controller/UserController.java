package com.pard.secondseminar.user.controller;


import com.pard.secondseminar.user.dto.UserDto;
import com.pard.secondseminar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Integer studentId) {
        return userService.findById(studentId);
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{studentId}")
    public void update(@PathVariable Integer studentId, @RequestBody UserDto userDto) {
        userService.update(studentId, userDto);
    }

    @DeleteMapping("{studentId}")
    public void delete(@PathVariable Integer studentId) {
        userService.delete(studentId);

    }

}
