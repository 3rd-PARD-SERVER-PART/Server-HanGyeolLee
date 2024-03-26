package com.pard.secondseminar.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // 로그 찍는 어노테이션
public class LogController {
    @GetMapping("/log")
    public String log(){
        String name = "Spring";

        log.info("name : {},", name); // + 써서 하면 메모리 소비 커짐.

        log.warn("name : {},", name);
        log.error("name : {},", name);
        log.debug("name : {},", name); // 여기서부터 설정 안하면 안나옴 -> 메모리 차지가 커질 수 있기 떄문.

        log.trace("name : {},", name);
        return "Hello";
    }
}
