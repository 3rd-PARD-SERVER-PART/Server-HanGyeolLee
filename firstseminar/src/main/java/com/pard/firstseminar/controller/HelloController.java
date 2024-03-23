package com.pard.firstseminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // restcontroller 로 바꾸는 애
public class HelloController {
    @RequestMapping("/hello") //맵핑.
    public String hello() {
        return "hello.html";
    }
















}
