package com.todolist.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todolist.demo.entities.Todo;
import com.todolist.demo.repositories.TodoRepository;

@Service
public class TodoService {
    final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll(){
        return todoRepository.findAll(Sort.by("priority").descending()
            .and(Sort.by("name").ascending()));
    }

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo, UUID id){
        Todo existingTodo = todoRepository.findById(id).get();

        BeanUtils.copyProperties(todo, existingTodo, "id");
        return todoRepository.save(existingTodo);
    }

    public void delete(UUID id){
        todoRepository.deleteById(id);
    }
}
