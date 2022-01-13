package com.todoapp.todo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.simple.JSONObject;

@RestController
public class TodoHomeController {

    @GetMapping("/")
    public String index() {

        JSONObject res = new JSONObject();
        JSONObject test = new JSONObject();
        JSONObject todo = new JSONObject();

        res.put("decription","API Path List");

        test.put("/GetMapping","GET");
        test.put("/{id}","GET");
        test.put("/reqparam","GET");
        test.put("/testReqBody","GET");
        test.put("/testResBody","GET");
        test.put("/testResEntity","GET");

        res.put("test/", test);

        todo.put("todoList/","GET");

        res.put("todo/", todo);

        return res.toJSONString();


    }
}