package com.todolist.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.demo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
    
}
