package com.todoapp.todo.service;

import org.springframework.stereotype.Service;

/*
어노테이션
    Service : 스테레오타입 어노테이션. Component 어노테이션과 유사하다.
*/

@Service
public class TodoService {
    public String testService(){
        return "Test Service";
    }
}
