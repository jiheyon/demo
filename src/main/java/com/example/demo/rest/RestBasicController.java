package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller   //스프링에 빈으로 등록하면서 얘를 검색하고 객체를 생성할 수 있도록 설정한것
// http://localhost:8181/china 오류남
// 서버사이드렌더링이 기본이고 HTML을 줄 수 없고 JSON을 보내야함
@ResponseBody // 이걸 추가해줘야함, 응답을 할 때 HTML을 응답하는게 아니라 JSON으로 응답하겠다는 아노테이션

public class RestBasicController {
    // 사용자가 어떤 리스트를 조회하고 싶다고 할 때
    // 조회 = GET
   @GetMapping("/china")
    public List<String> food(){
       List<String> foodList = Arrays.asList("마파두부", "꿔바로우", "마라탕");

       return foodList;
    }
}
