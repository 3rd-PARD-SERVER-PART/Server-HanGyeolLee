package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController

public class HiController {
    @RequestMapping("/hi")
    public String hi(@RequestParam Map<String, Objects> paraMap) {
        return "이한결/23/전산심화/음악듣기\n" +
                "\n여기서 부터는 받은것 : "+
                paraMap.get("name")+"/"
                +paraMap.get("age")+"/"
                +paraMap.get("major")+"/"
                +paraMap.get("hobby");
    }
}