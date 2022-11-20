package com.example.demo.rest;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/json")
@Slf4j  // 로깅 라이브러리 - 잡다한 로그까지 찍어주고 파일 입출력까지 해주는 어노테이션
public class RestJsonController {
    /**
     * 로그 레벨
     *
     * TRACE - 잡다한 내용을 로깅 (1초마다 서버가 돌아가는 기록)
     * DEBUG - 개발 당시 확인할 내용들 로깅
     * INFO - 운영시 필요한 정보들을 로깅
     * WARN - 에러까지는 아닌데 경고상황 로깅 (심각한 상황은 x)
     * ERROR - 서버에 위협을 부르는 심각한 에러 로깅
     *
     * sout은 무겁고 로그레벨도 구분없고 로그파일에 기록도 해야되서 이거로 로그찍지 않음!
     */

    @PostMapping("/major")
    //public List<String> major(@RequestBody  String nickName) {  //RequestBody : json으로 온건 이거로 받음

    // 전공을 목록으로 받으려고 할 떄
    public List<String> major(@RequestBody  List<String> majorList) {
        // @RequestBody이거 있으면 jsin으로 와야함, List=[]={} 이렇게 대응됨

        log.info("/json/major POST request! - {}",majorList);
        return null;
    }

    @PutMapping("/bbs")
    public void bbs(@RequestBody Article article) { // RequestBody json형태로 달라, 바디에 json형태로 보내야함
        log.info("/json/bbs PUT request! - {}", article);  // 리스트랑 배열만 대괄호 나머진 중괄호
    }

    @DeleteMapping("/bbs-list")
    public void bbsList(@RequestBody List<Article> list) {  // 정보 3개 보내기
        log.info("/json/bbs-list DELETE request! - {}", list);
    }


    @Setter @Getter @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Article {

        private long id;
        private String title;
        private String content;
        private String writer;
    }

}