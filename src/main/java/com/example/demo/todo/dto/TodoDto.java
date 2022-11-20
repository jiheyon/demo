package com.example.demo.todo.dto;

import lombok.*;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private long id;
    private String title;
    private boolean done;
}
