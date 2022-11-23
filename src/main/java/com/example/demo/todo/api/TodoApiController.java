 package com.example.demo.todo.api;

            import com.example.demo.todo.dto.FindAllDTO;
            import com.example.demo.todo.entity.ToDo;
            import com.example.demo.todo.repository.TodoRepository;
            import com.example.demo.todo.service.TodoService;
            import lombok.RequiredArgsConstructor;
            import lombok.extern.slf4j.Slf4j;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.http.ResponseEntity;
            import org.springframework.web.bind.annotation.*;

            import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService service;
    /*   @RequiredArgsConstructor >> 생성자 안만들어도 자동주입임.
              @Autowired   // 셍상지  주입
              public TodoApiController(TodoRepository repository) {
                  this.repository = repository;
              }
              */

       // 할 일 목록 전체조회 요청
    @GetMapping
    public ResponseEntity<?> todos() {
        log.info("/api/todos GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }


    // 할 일 목록 등록 요청 >> 클라이언트가 정보를 알려줘야함
    @PostMapping //새롭게 등록된 할일이 포함된 리스트를 전달해줄거임
    public ResponseEntity<?> create(@RequestBody ToDo newTodo) { // 클라이언트가 웹이 아닐수도 있으니까 json으로 변환해야됨

        newTodo.setUserId("noname");
        log.info("/api/todos POST request! - {}", newTodo);


        try {
            FindAllDTO dto = service.createServ(newTodo);
              if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /*
    // Q! : 할 일 개별 조회 요청
    @GetMapping
    public ResponseEntity<?> oneTodo() {
        log.info("/api/todos GET request!");
        return ResponseEntity.ok().body(service.findOneServ());
    }
    */


    // 컨트롤러랑 서비스만 구현하면 됨, Repository는 이미 검증 끝났음



    // ★ Q! : 할 일 개별 조회 요청(숙제)
    // URL : /api/todos/3 => 3번 할 일만 조회해서 클라이언트에게 리턴 (GET)

    // Q! : 할 일 삭제 요청
    // URL : /api/todos/3 => 3번 할 일을 삭제 후 이후 갱신된 할일 목록 리턴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {  // {} 값 읽는거 @PathVariable

        log.info("/api/todos/{} DELETE request!", id);

        try {
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}




