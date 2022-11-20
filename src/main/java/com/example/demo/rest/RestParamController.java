package com.example.demo.rest;

import lombok.*;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/param")
public class RestParamController {

    @GetMapping("/user")  // URL : /param/user?name=홍길동
    public String userName(HttpServletRequest request) { // Request객체를 쓸 수 있다는것만 알아두기

        // 홍길동
        String name = request.getParameter("name");

        return String.format("당신의 이름은 %s입니다.", name);
    }

   @GetMapping("/user2")  //  /param/user2?name=짹짹이&age=25
    public String userName(
            @RequestParam(value = "name", required = false) String nm,
            @RequestParam(defaultValue = "10") int age
    ) {

        return String.format(
                "당신의 이름은 %s님이고, 나이는 %d세입니다."
                , nm, age);
    }


    // /param/user3?name=김철수&age=30&address=서울&height=171.88&hobby=축구&hobby=농구
    // 이럴땐 DTO객체 만들어서 처리함=내용이 많을 떄
    @GetMapping("/user3")
    public String user3(UserDTO userInfo) {

        return String.format(
                "당신의 이름은 %s님이고, 나이는 %d세이고, "
                        + "주소는 %s이며, 키는 %.2fcm며 취미는 %s들이다."
                , userInfo.getName()
                , userInfo.getAge()
                , userInfo.getAddress()
                , userInfo.getHeight()
                , userInfo.getHobby()

        );
    }

    @Setter // 필수, 없으면 DTO작동안함
    @Getter
    @ToString
    @NoArgsConstructor // 필수, 없으면 DTO작동안함
    @AllArgsConstructor
    public static class UserDTO{

        private String name;
        private int age;
        private String address;
        private double height;
        private List<String> hobby;
    }
}

