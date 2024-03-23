package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestAPTController {

    @GetMapping("/{userId}")
    public String hi(@PathVariable Integer userId){
        return "get으로 온 컨트롤러" + userId;
    }

    @GetMapping
    public String userAll(){
        return "Get:user all";
    }

    @PostMapping
    public String userCreate(){
        return "POST : userCreate";
    }
    @PutMapping
    public String userUpdate(){
        return "Put : user Update";
    }

    @PatchMapping
    public String userUpdateByPatch(){
        return "Patch : user update";
    }
    @DeleteMapping
    public String userDelete(){
        return "Delete : user Delete";
    }

}
