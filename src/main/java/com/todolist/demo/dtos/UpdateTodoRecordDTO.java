package com.todolist.demo.dtos;

import java.util.Optional;

public record UpdateTodoRecordDTO(
    Optional<String> name, 
    Optional<String> description, 
    Optional<Boolean> done,
    Optional<Integer> priority) {
    
}
