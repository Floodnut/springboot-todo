package com.todoapp.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
    private String id;
    private String userId;
    private String title;
    private boolean done;
}

/*
Entity
    규모가 큰 프로젝트는 모델과 엔티티는 구분될 수 있으나 이 프로젝트는 규모가 작으니 하나로 구현
    

Annotation
    Builder : Builder 패턴을 사용하여 값 할당 가능
    NoArgsConstructor : 매개변수 없는 생성자 구현
    AllArgsConstructor : 클래스 내부의 모든 멤버 변수를 매개변수로 받는 생성자 구현
    Data : get/set 메서드 구현 대체
*/