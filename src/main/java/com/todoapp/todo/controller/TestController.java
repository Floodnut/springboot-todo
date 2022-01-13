package com.todoapp.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.simple.JSONObject;


@RestController
@RequestMapping("test")
public class TestController {
    
    @GetMapping("/GetMapping")
    public String testController(){
        return "API GET Test";
    }

    @GetMapping("/{id}")
    public String testControllerPathVariable(
        @PathVariable(required = false) int id
    ){
        JSONObject res = new JSONObject();

        res.put("decription","API GET PathVariable Test");
        res.put("id", id);

        return res;
    }

    @GetMapping("/reqparam")
    public String testControllerReqParam(
        @RequestParam(required = false) int id
    ){
        JSONObject res = new JSONObject();

        res.put("decription","API GET RequestParam Test");
        res.put("id", id);

        return res;
    }
}
