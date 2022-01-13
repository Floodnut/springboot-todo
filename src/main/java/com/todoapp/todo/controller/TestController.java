package com.todoapp.todo.controller;


import com.todoapp.todo.dto.ResponseDTO;
import com.todoapp.todo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("test")
public class TestController {
    
    @GetMapping("/GetMapping")
    public String testController(){
        return "API GET Test";
    }

    /*
    Request Path
        HTTP GET 메소드로 인자를 받는다.
        경로를 동적으로 변환
    */
    @GetMapping("/{id}")
    public String testControllerPathVariable(
        @PathVariable(required = false) int id
    ){
        JSONObject res = new JSONObject();

        res.put("decription","API GET PathVariable Test");
        res.put("id", id);

        return res.toJSONString();
    }

    /*
    Request Get Param
        HTTP GET 메소드로 인자를 받는다.
    */
    @GetMapping("/reqparam")
    public String testControllerReqParam(
        @RequestParam(required = false) int id
    ){
        JSONObject res = new JSONObject();

        res.put("decription","API GET RequestParam Test");
        res.put("id", id);

        return res.toJSONString();
    }

    /*
    RequestBody
        Body의 인자로 JSON 스트링을 받는다.
    */
    @GetMapping("/testReqBody")
    public String testControllerReqBody(
        @RequestBody TestRequestBodyDTO testRequestBodyDTO
    ){
        JSONObject res = new JSONObject();

        res.put("decription","API GET RequestBody Test");
        res.put("id", testRequestBodyDTO.getId());
        res.put("message", testRequestBodyDTO.getMessage());

        return res.toJSONString();
    }

    /*
    객체 반환
        요청에 대해 객체를 반환
        객체는 ResponseDTO에 의해 반환
        ResponseDTO는 제네릭 타입을 가져 원하는 타입으로 선언할 수 있다.
    */
    @GetMapping("/testResBody")
    public ResponseDTO<String> testControllerResBody(){
        List<String> list = new ArrayList<>();
        
        list.add("API GET RequestBody Test");
        list.add("id");
        list.add("message");

        ResponseDTO<String> res = ResponseDTO.<String>builder()    
                                                .data(list)
                                                .build();

        return res;
    }
    
    /*
    HTTP 응답 상태 반환
        HTTP Method를 함께 반환
    */
    @GetMapping("/testResEntity")
    public ResponseEntity<?> testControllerResEntity(){
        List<String> list = new ArrayList<>();
        list.add("Response Entity Test. Status Check");
        list.add("Status : 400");
        ResponseDTO<String> res = ResponseDTO.<String>builder().data(list).build();

        //return ResponseEntity.status(200).body(res);
        return ResponseEntity.badRequest().body(res);
    }
}