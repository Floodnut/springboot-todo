package com.todoapp.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Entity
    규모가 큰 프로젝트는 모델과 엔티티는 구분될 수 있으나 이 프로젝트는 규모가 작으니 하나로 구현
    

Annotation
    Builder : Builder 패턴을 사용하여 값 할당 가능
    NoArgsConstructor : 매개변수 없는 생성자 구현
    AllArgsConstructor : 클래스 내부의 모든 멤버 변수를 매개변수로 받는 생성자 구현
    Data : get/set 메서드 구현 대체
    Entity : 자바 클래스를 DB 엔터티로 지정. 매개변수로 이름을 지정하지 않는 경우 클래스 이름을 테이블 명으로 지정.
    Table : 자바 엔터티가 사용할 DB 테이블 매핑.
    Id: DB 테이블의 키 지정
    GeneratedValue : 생성 방식에 따라 ID를 자동 생성.
    GenericGenerator :  Hibernate의 기본 제네레이터가 아닌 커스텀 제네레이터를 사용. GeneratedValue가 이 제네레이터를 참조하여 사용한다.
*/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userid;
    private String title;
    private boolean done;
}
