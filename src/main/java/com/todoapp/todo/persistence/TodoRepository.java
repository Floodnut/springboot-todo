package com.todoapp.todo.persistence;


import org.springframework.data.jpa.repository.JpaRepository; //인터페이스
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.todoapp.todo.model.TodoEntity;

/*
어노테이션
    Repository : Component 어노테이션의 특수 케이스. 스프링이 관리한다.

JPA
    jpa는 기본 쿼리가 아닌 커스텀 쿼리들을 아래와 같은 클래스들에서 메서드 명을 파싱하여 실행한다.
    "select * from TodoRepository where userid = '{userid}'"
*/


@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String>{
    
    @Query("select * from todo t where t.userid = ?1") // ?1은 메서드의 매개변수의 순서 위치
    List<TodoEntity> findByUserid(String userid); // 메서드 명은 쿼리, 매개변수는 쿼리의 where 절 조건
}
