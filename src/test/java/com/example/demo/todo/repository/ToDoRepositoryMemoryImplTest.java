package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  //스프링 컨테이너를 테스트 클래스에서 사용가능하게 만들어주는 어노테이션
class ToDoRepositoryMemoryImplTest {
    // 진짜로 save하는지, 전체 조회해주는지 섹제 하는지 등을 테스트로 확인해봐야함

    @Autowired
    TodoRepository repository;

    // 단언 : 강력하게 주장한다
    @Test
    @DisplayName("저장소에서 목록을 조회했을 때 할 일의 개수가 3개여야 한다")
    void findAllTest(){
        // given :테스트 시 필요한 데이터 넣어줄 데이터가 없으니까 생략해도 됨

        // when : 테스트의 실제 상황
        List<ToDo> toDoList = repository.findAll();

        // then : 테스트 결과 단언
        assertEquals(3, toDoList.size()); // 목록이 3개니까 사이즈 3개라고 단언 가능
        assertNotNull(toDoList);

    }

    // 단일 확인, @DisplayName은 필수 아님
    @Test
    @DisplayName("아이디가 2번인 할 일 데이터를 조회했을 때 그 작성자 이름이 박영의여야 한다")
    void findOneTest() {
        // given :테스트 시 필요한 데이터가 있음
        long id = 2L;

        // when : 테스트의 실제 상황
         ToDo toDo = repository.findOne(id);

        // then : 테스트 결과 단언
        assertEquals("박영희", toDo.getUserId());
        assertFalse(toDo.isDone());  // 실무에서는 실패테스트도 있고 실패상황이 문서로 내려오기도 함
  }
@Test
@DisplayName("1번 할 일을 삭제한 후 다시 조회했을 때 null이 나와야 한다")
void removeTest() {
    // given
    long id = 1L;
    // when
    boolean flag = repository.remove(id);
    ToDo toDo = repository.findOne(id);
    // then
    assertTrue(flag); // 삭제됐으니까 트루
    assertNull(toDo); // 삭제된거니까 Null
    assertEquals(2,repository.findAll().size()); // 2개
    }

    // 할 일 등록테스트
    @Test
    @DisplayName("새로운 4번 할일을 등록했을 때 전체목록의 개수가 4개여야 한다.")
    void saveTest() {
        // given
        ToDo newTodo = new ToDo(4L, "말똥이", "낮잠자기", false);

        // when
        boolean flag = repository.save(newTodo);
        List<ToDo> toDoList = repository.findAll();

        // then
        assertTrue(flag);
        assertEquals(4, toDoList.size());

    }
}