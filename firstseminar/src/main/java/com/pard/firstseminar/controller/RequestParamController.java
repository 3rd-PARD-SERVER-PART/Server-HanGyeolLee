package com.pard.firstseminar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {
    @RequestMapping("/requesttestV1")

    // 애는 순서 상관 없이 받긴 함!, 근데 가능하면 맞추는게 좋은 것 같음.
    public String requestParam(@RequestParam("name") String hiName,
                               @RequestParam("age") int hiAge) {
        return "requestParam 연습 name : " + hiName + "Age :" + hiAge;
    }

    // 굳이 설정 안해도 이름 같으면 들어감. -> 애가 알아서 찾는거 같음
    @RequestMapping("/requesttestV2")
    public String requsetParamV2(@RequestParam String name,
                                 @RequestParam int age) {
        return "requestParamV2 연습 name : " + name + "Age :" + age;
    }

    // 가능은 한데 권장은 안함.
    @RequestMapping("/requesttestV3")
    public String requsetParamV3(String name,
                                 int age) {
        return "requestParamV2 연습 name : " + name + "Age :" + age;
    }


    // int, float -> 원시 함수는 null 을 받지 못합니다.
    // 가능은 한데 권장은 안함. null 떄문에 권장 안함...
    @RequestMapping("/requesttestV4")
    public String requsetParamV4(@RequestParam(required = true) String name,
                                 @RequestParam(required = false) Integer age) {
        return "requestParamV4 연습 name : " + name + "Age :" + age;
    }

    // 추천되는 방법.
    @RequestMapping("/requesttestV5")
    public String requsetParamV5(@RequestParam(defaultValue = "이한결") String name,
                                 @RequestParam(defaultValue = "23") int age) {
        return "requestParamV5 연습 name : " + name + "Age :" + age;
    }

//    // 추천되는 방법. 이름을 지정하고 싶을 때
//    @RequestMapping("/requesttestV5")
//    public String requsetParamV5( @RequestParam(value = "name", defaultValue = "이한결") String name,
//                                  @RequestParam(value = "age", defaultValue = "23") int age) {
//        return "requestParamV5 연습 name : " + name + "Age :" + age;
//    }

    // 권장은 안하는데, 코드 작성하기엔 빠름. and 안전성이 낮음
    @RequestMapping("/map")
    public String requsetParamMap(@RequestParam Map<String, Object> paraMap) {
        return "requestParamV5 연습 name : " + paraMap.get("name") + "Age :" + paraMap.get("age");
    }


}
