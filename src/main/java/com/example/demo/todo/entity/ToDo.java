package com.example.demo.todo.entity;

import lombok.*;

@Setter @Getter @ToString
// @NoArgsConstructor 기본 생성자 주석처라:아래 일련번호 시퀀스 직접 생성때문에!
@AllArgsConstructor // 전체 필드 초기화 생성자
// 역할 : 하나의 할 일 데이터의 집합 객체
public class ToDo {

    private long id; // 할일들을 식별하는 번호
    private String userId; // 할 일을 등록한 회원의 식별자
    private String title; //할 일 내용
    private boolean done; // 할 일 완료 여부

    //롬복이 생성자, 셋겟터 기본생성자, 올파라미터 생성자 다 만들어줌
    // @Data는 쓰지말기 -> 단일수정 불가

    // 일련번호
    private static long seq; //  static 없이 그냥하면 아이디++안됨, 스테틱 없으면 개별 1개씩이고 static을 붙이면 seq1개임

    public ToDo() {
        this.id = ++seq;
    }

    public ToDo(String title) {  // 클라이언트가 준거 넣을거임
        this(); // 내부에서만 가능, 나의 기본생성자 호출!! , 원래 외부에서 생성자 두개를 호출하진 못하니까!, 무조건 첫줄에 써야함
        this.title = title;
        this.userId = "noname";
        // this.done = false;  기본값이 false이라 안써도 됨
    }
}
