package com.todolist.demo.controllers;

import com.todolist.demo.dtos.TodoRecordDTO;
import com.todolist.demo.entities.Todo;

public class TodoMapper {
    public static TodoRecordDTO FormatPlaceCreate(Todo todo) {
        return new TodoRecordDTO(todo.getName(), todo.getDescription(), todo.getDone(), todo.getPriority());
    }
}
