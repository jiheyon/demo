package com.example.demo.todo.service;

// 역할 : 컨트롤러와 저장소 사이즤 잡일 처리 역할

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // 컨트롤러와 레파지토리 사이에 있음. 서비스>레파짓토리 의존
@Slf4j
@RequiredArgsConstructor // 생성자 만들기
public class TodoService {

    private final TodoRepository repository;

    /*
        - 할 일 목록조회 중간처리 - 이거 해줘야함
        1. 컨트롤러에게 userId를 뺀 할 일 리스트를 전달한다.
        2. 할 일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */

    public void findAllServ(){
        List<ToDo> toDoList = repository.findAll();   // 랴ㅜㅇ미ㅣㅇ새fh qusghksgotj wnjdigka

        FindAllDTO findAllDTO = new FindAllDTO();
        findAllDTO.setCount(toDoList.size()); //목록 리스트 사이즈 담아서 주기
        List<TodoDto> dtos = new ArrayList<>();

        for (ToDo toDo : toDoList) {
            TodoDto dto = new TodoDto();
            dto.setId(toDo.getId());
            dto.setTitle(toDo.getTitle());
            dto.setDone(toDo.isDone());

            dtos.add(dto);
        }
        findAllDTO.setTodos(dtos);
    }
}
