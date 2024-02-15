package com.todolist.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.demo.dtos.CreateTodoRecordDTO;
import com.todolist.demo.entities.Todo;
import com.todolist.demo.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody CreateTodoRecordDTO request) {
        var newTodo = new Todo();
        var record = new CreateTodoRecordDTO(request.name(), request.description(), false, request.priority());
        BeanUtils.copyProperties(record, newTodo);
        var response = todoService.create(newTodo);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.status(200).body(todoService.getAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable("id") UUID id) {
        System.out.println(todo);
        return ResponseEntity.status(201).body(todoService.update(todo, id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        todoService.delete(id);
    }
}
