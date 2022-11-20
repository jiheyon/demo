package com.example.demo.todo.dto;

import com.example.demo.todo.entity.ToDo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count; // 할 일 목록의 개수
    private List<TodoDto> todos;  // userId가 빠진 할 일 목록


    public FindAllDTO(List<ToDo> toDoList) {     // 생성자
        this.count = toDoList.size();  // 위에서 초기하해줌
        this.convertDtoList(toDoList); // 컨벌트 디이토리시트가 내부에서 초기화해줌
    }   // count, todos 이거를 받는게 목적임

    // List<ToDo>를 받으면 List<TodoDto>로 변환하는 메서드
    public void convertDtoList(List<ToDo> toDoList) {
        List<TodoDto> dtos = new ArrayList<>();

        // for문 : 유저ID만 빼고 넣는 작업임
        for (ToDo toDo : toDoList) {
            // 이식하는 생성자를 아예 만들꺼임,  생성자한테 toDo를 보냈음
            dtos.add(new TodoDto(toDo));
        }
        this.todos = dtos;
    }

}
