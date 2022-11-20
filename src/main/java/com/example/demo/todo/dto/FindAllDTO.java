package com.example.demo.todo.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count; // 할 일 목록의 개수
    private List<TodoDto> todos;  // userId가 빠진 할 일 목록


}
