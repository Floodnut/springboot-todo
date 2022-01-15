package com.todoapp.todo.service;

import com.todoapp.todo.persistence.TodoRepository;
import com.todoapp.todo.model.TodoEntity;

/* 
    slf4j 대신 사용할 자바 기본 라이브러리
*/
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/*
어노테이션
    Service : 스테레오타입 어노테이션. Component 어노테이션과 유사하다.
    Slf4j : 로깅을 위한 라이브러리. Log4j2를 사용하여 Log4Shell 취약점에 대한 방지책 고려해야함.

*/

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService(){

        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().userid("floodnut").title("Todo Item 1").build();

        // TodoEntity 저장
        repository.save(entity);

        // TodoEntity 검색
        TodoEntity savedEntity = repository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }

    public List<TodoEntity> create(final TodoEntity entity){
        //validations


        repository.save(entity);
        //log.info("Entity ID : {} is saved", entity.getId());

        return repository.findByUserid(entity.getUserid());
    }

    private void validate(final TodoEntity entity){
        Logger logger = Logger.getLogger("TodoEntity Log");

        if(entity == null){
            log.warn("Entity cannot be null"); //slf4j logger

            //logger.setLevel(Level.WARNING); //java standard logger
            //logger.warning("Entity cannot be null");

            throw new RuntimeException("Entity cannot be null");
        }

        if(entity.getUserid() == null){
            log.warn("Unknown User");

            //logger.setLevel(Level.WARNING); //java standard logger
            //logger.warning("Entity cannot be null");

            throw new RuntimeException("Unknown User");
        }
    }
}
