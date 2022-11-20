package com.example.demo.rest;
// REST 실습
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
@Controller   //스프링에 빈으로 등록하면서 얘를 검색하고 객체를 생성할 수 있도록 설정한것
// http://localhost:8181/china 오류남
// 서버사이드렌더링이 기본이고 HTML을 줄 수 없고 JSON을 보내야함
@ResponseBody // 이걸 추가해줘야함, 응답을 할 때 HTML을 응답하는게 아니라 JSON으로 응답하겠다는 아노테이션
*/
@RestController  // @Controller+@ResponseBody
public class RestBasicController {
    // 사용자가 어떤 리스트를 조회하고 싶다고 할 때
    // 조회 = GET
   @GetMapping("/china")
    public List<String> food(){
       List<String> foodList = Arrays.asList("마파두부", "꿔바로우", "마라탕");

       return foodList;
    }
    @GetMapping("/hobby")
    public Map<String, String> hobbies() {
       Map<String, String> hobbies = new HashMap<>();

       hobbies.put("운동", "축구");
       hobbies.put("여가", "산책");
       hobbies.put("맛집", "한우");

       return hobbies;
    }

    @GetMapping("/number")
    public int[] number(){

        int[] arr = {2, 4, 6, 8};
        return arr;
    }
    @GetMapping("/score")
    public Score score() {
        return new Score("김철수", 99, 50, 'B');
    }

    @GetMapping("/score-list")
    public List<Score> scoreList() {
        return Arrays.asList(
                new Score("김철수", 99, 50, 'B'),
                new Score("박영희", 55, 77, 'A'),
                new Score("송사리", 33, 88, 'D')
        );
    }


    @Setter@Getter@ToString
    @AllArgsConstructor
    public static class Score{

       private String name;
       private int javaExam;
       private int mathExam;
       private char grade;

    }
}
