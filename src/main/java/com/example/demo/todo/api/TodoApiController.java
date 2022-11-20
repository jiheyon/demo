 package com.example.demo.todo.api;

            import com.example.demo.todo.dto.FindAllDTO;
            import com.example.demo.todo.entity.ToDo;
            import com.example.demo.todo.repository.TodoRepository;
            import com.example.demo.todo.service.TodoService;
            import lombok.RequiredArgsConstructor;
            import lombok.extern.slf4j.Slf4j;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.web.bind.annotation.*;

            import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService service;
    /*   @RequiredArgsConstructor >> 생성자 안만들어도 자동주입임.
              @Autowired   // 셍상지 주입
              public TodoApiController(TodoRepository repository) {
                  this.repository = repository;
              }
              */

       // 할 일 목록 전체조회 요청
    @GetMapping
    public FindAllDTO todos() {
        log.info("/api/todos GET request!");
        return service.findAllServ();
    }

    // 할 일 목록 등록 요청 >> 클라이언트가 정보를 알려줘야함
    @PostMapping   //새롭게 등록된 할일이 포함된 리스트를 전달해줄거임
    public FindAllDTO create(@RequestBody ToDo newTodo) { // 클라이언트가 웹이 아닐수도 있으니까 json으로 변환해야됨

        newTodo.setUserId("noname"); // 수동 주입
        log.info("/api/todos POST request! - {}", newTodo);

        FindAllDTO dto = service.createServ(newTodo);

       return dto;
    }

}



