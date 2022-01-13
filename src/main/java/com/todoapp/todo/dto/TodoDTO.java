package com.todoapp.todo.dto;

import com.todoapp.todo.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
DTO
    서비스 요청 결과 반환을 위해 DB에 접근할 때, Model에 직접 접근하지 않는다.
    데이터 전달 객체인 DTO를 통해 반환한다.
    이유 : 캡슐화, DB 모델이 모든 정보를 가지지 않을 경우   

Annotation
    Builder : Builder 패턴을 사용하여 값 할당 가능
    NoArgsConstructor : 매개변수 없는 생성자 구현
    AllArgsConstructor : 클래스 내부의 모든 멤버 변수를 매개변수로 받는 생성자 구현
    Data : get/set 메서드 구현 대체
*/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO { //For TodoItem CRUD
    private String id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }
}
