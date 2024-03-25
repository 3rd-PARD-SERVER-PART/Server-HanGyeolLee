package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestAPIController {
    @GetMapping("/{userId}")
    public String hi(@PathVariable Integer userId) {
        return "Get으로 온 컨트롤러" + userId;
    }

    @GetMapping
    public String userAll() {
        return "Get : userAll";
    }

    @PostMapping
    public String userCreate() {
        return "POST : userCreate";
    }
    @PostMapping ("/{userId}")
    public String post(@PathVariable Integer userId) {
        return "{Post} 온 컨트롤러" + userId;
    }


    @PutMapping
    public String userUpdate() {
        return "Put : user Update";
    }

    @PatchMapping
    public String userUpdateByPatch() {
        return "Patch : user Update";
    }

    @DeleteMapping
    public String userDelete() {
        return "Delete : user Delete";
    }

}