package com.example.demo.todo.service;


        import com.example.demo.todo.dto.FindAllDTO;
        import com.example.demo.todo.dto.TodoDto;
        import com.example.demo.todo.entity.ToDo;
        import com.example.demo.todo.repository.TodoRepository;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;

// 역할: 컨트롤러와 저장소 사이의 잡일 처리 역할
@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    /*
        - 할 일 목록조회 중간처리 - 이거 해줘야함
        1. 컨트롤러에게 userId를 뺀 할 일 리스트를 전달한다.
        2. 할 일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */

    public FindAllDTO findAllServ() {
        return new FindAllDTO(repository.findAll());
    }

    public FindAllDTO createServ( final ToDo newTodo) {  // 내부에서new ToDo() 못하게 final 선언하기

        if (newTodo == null){
            log.warn("newTodo cannot be null!");
            throw new RuntimeException("newTodo cannot be null!");
        }

        boolean flag = repository.save(newTodo);
        if (flag) log.info("새로운 할일 [Id : {}]이 저장되었습니다.", newTodo.getId());
        return flag ? findAllServ() : null; // 삽입하고 결과리소스를 다시 반환하기, 위에 있는 findAllServ 활용하기

    }

    /*
    // Q! : 할 일 개별 조회 요청
    public FindAllDTO findOneServ() {

        return FindAllDTO(repository.findOne());
    }
    */

    // Q! : 할 일 삭제 요청
    public FindAllDTO deleteServ(long id) {

        boolean flag = repository.remove(id);

        // 삭제 실패한 경우
        if (!flag) {
            log.warn("delete fail!! not found id [{}]", id);
            throw new RuntimeException("delete fail!"); // >> throw 만나면 원래 터짐,
        }
        return findAllServ();
    }

}



        //List<ToDo> toDoList = repository.findAll();
        // List<ToDo>  List<Dto>로 만드는 코드 생성
        // FindAllDTO findAllDTO = new FindAllDTO(toDoList);

        /*
        FindAllDTO findAllDTO = new FindAllDTO(toDoList);
        findAllDTO.setCount(toDoList.size());
        findAllDTO.convertDtoList(toDoList);
        */
        //return findAllDTO;
