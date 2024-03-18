package com.example.demoapi.repository;

import com.example.demoapi.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(long id);
    Boolean existsById(long id);
}
