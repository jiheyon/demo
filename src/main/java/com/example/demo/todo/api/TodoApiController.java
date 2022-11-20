package com.example.demo.todo.api;

import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @Slf4j
    @RequestMapping("/api/todos")
    @RequiredArgsConstructor
    public class TodoApiController {

        private final TodoRepository repository;
        /*   @RequiredArgsConstructor >> 생성자 안만들어도 자동주입임.
           @Autowired   // 셍상지 주입
           public TodoApiController(TodoRepository repository) {
               this.repository = repository;
           }
           */
        // 할 일 목록 전체조회 요청
        @GetMapping
        public List<ToDo> todos() {
            log.info("/api/todos GET request!");

            return repository.findAll();
        }
    }


