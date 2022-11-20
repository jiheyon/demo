package com.example.demo.todo.dto;

import com.example.demo.todo.entity.ToDo;
import lombok.*;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private long id;
    private String title;
    private boolean done;

    // ToDo에서 Tododto가 필요한 필드를 가져오는 생성자-임포트 시킴
    public TodoDto(ToDo toDo){
    this.id = toDo.getId();
    this.title = toDo.getTitle();
    this.done = toDo.isDone();
            // 이렇게하면 세터 안불러도 됨
    }
}
