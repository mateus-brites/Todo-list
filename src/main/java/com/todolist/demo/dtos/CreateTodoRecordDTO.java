package com.todolist.demo.dtos;

public record CreateTodoRecordDTO(String name, String description, Boolean done, Integer priority) {
    
}
