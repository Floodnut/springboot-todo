package com.todoapp.todo.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
HTTP RESPONSE
    요청에 대해 반환을 해주는 DTO

제네릭
    List<T>로 자바 제네릭을 통해 여러 모델의 DTO 반환 가능
*/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {
    private String error;
    private List<T> data;   //여러 타입의 배열 가능
}
