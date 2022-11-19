package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;

// 이 클라스가 하는 일 : 할 일 데이터를 메모리에 CRUD하는 역할
// 아깐 추상적이고 지금은 메모리라고 구체적으로 정했음
@Repository
public class ToDoRepositoryMemoryImpl implements TodoRepository{

//  메모리 저장소
    /**
     * key : 할 일 식별 id값
     * value: 할 일 집합 객체
     * 원시타입 >> 객체타입 변경시 대문자 기입 유의
     */
    private static final Map<Long, ToDo> toDoMap = new HashMap<>();
    // static을 붙이니|까 한개만 생성됨
    // final = 교체불가로 기입

    static {
        toDoMap.put(1L, new ToDo(1L, "김철수", "저녁밥 만들기", false));
        toDoMap.put(2L, new ToDo(2L, "박영희", "산책가기", false));
        toDoMap.put(3L, new ToDo(3L, "김철수", "노래연습하기", true));
    }

    @Override
    public boolean save(ToDo todo) {
        if (todo == null) return false;

        // else
        toDoMap.put(todo.getId(), todo);
        return true;
    }

    @Override
    public List<ToDo> findAll() {

        // 맵에 있는걸 꺼내서
        //전제 조회가 더 많이 =  어레이리스트
        List<ToDo> toDoList = new ArrayList<>();

        for(Long id : toDoMap.keySet()){
            ToDo toDo = toDoMap.get(id);
            toDoList.add(toDo);
        }
        return toDoList;
    }

    @Override
    public ToDo findOne(long id) {

        return toDoMap.get(id);
    }

    @Override
    public boolean remove(long id) {
        ToDo todo = toDoMap.remove(id); // 삭제에 성공하면 값을 뱉어냄(값을 리턴함), 리턴벨류가 널이하면 삭제 안된거임
        // 널 뱉으면 삭제 시류ㅐ한거임
        return todo != null; // 이거면 true임

        /*
        if (todo != null) return true;
        else return false; // 이거면 true임
        */

    }
}
