package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;

import java.util.List;

// 아직 저장소가 선택된게 전혀 없음, 일단 개발은 해야되니까 인터페이스부터 만듬
// 역할 : 할 일 데이터를 CRUD한다(CRUD = 생성, 조회, 수정, 삭제)
public interface TodoRepository {
    // 추상적으로
    // 할 일 생성 기능(이름부터 짓기, 회사에선 다이어그램 내려옴 ㅎㅎ)

    /**
     * 할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공시 true, 실패시 false 반환
     */
    boolean save(ToDo todo); // 할 일 생성하려면 데이터가 필요함, 클래스 Todo를 넘겨주기, 생성여부는 불린으로


    // 할 일 목록조회 기능
    List<ToDo> findAll();  // 할일은 딱히 뭔가를 할 필요는 없고 대신 여러개니까

    // 할 일 개별조회 기능
    ToDo findOne(long id); //하나만 조회하니까

    // 할 일 삭제기능
    boolean remove(long id); //하나만 삭제하는거니까

}
