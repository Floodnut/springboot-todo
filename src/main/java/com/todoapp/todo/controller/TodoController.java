package com.todoapp.todo.controller;

import com.todoapp.todo.dto.ResponseDTO;
import com.todoapp.todo.dto.TodoDTO;
import com.todoapp.todo.model.TodoEntity;
import com.todoapp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
/*
어노테이션
    AutoWired : 생성자를 통해 자동으로 객체를 생성하고 초기화하는 작업을 수행한다.
    RestController : 이 어노테이션 역시 내부에 Component 어노테이션을 가진다.

자바 빈
    Service, RestController 모두 자바 빈이여서 스프링이 관리한다.
    AutoWired가 빈을 찾아 그 빈을 인스턴스 멤버 변수에 연결한다.
    따라서 스프링이 자동적으로 초기화 한다.
*/

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    /*
    HTTP 응답 상태 반환
        HTTP Method를 함께 반환
    */
    @GetMapping("/todoList")
    public ResponseEntity<?> todoController(){
        List<String> list = new ArrayList<>();
        list.add("Response Entity Test. Status Check");
        list.add("Status : 400");
        ResponseDTO<String> res = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.badRequest().body(res);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testTodo(){
        String str = service.testService();
        List<String> list = new ArrayList<>();

        //list.add("Todo Finded");
        list.add(str);
        ResponseDTO<String> res = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(
        @RequestBody TodoDTO dto
    ){
        try{
            String temporaryUserId = "temp-User-1";

            // DTO to TodoEntity
            TodoEntity entity = TodoDTO.toEntity(dto);

            // Init id null.
            // When it's created, there should be no id.
            entity.setId(null);
            
            // set UserID
            entity.setUserid(temporaryUserId);

            // Create Todo Entity with Service.
            List<TodoEntity> entityList = service.create(entity);

            // Convert returned Entity List to TodoDTO List.
            List<TodoDTO> dtos = entityList.stream().map(TodoDTO::new).collect(Collectors.toList());

            // Init ResponseDTO using converted TodoDTO LIST.
            ResponseDTO<TodoDTO> res = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(res);
        }catch(Exception e){
            String error = e.getMessage();
            ResponseDTO<TodoDTO> res = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(res);
        }
    }
}
