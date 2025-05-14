package com.example.reactiveDemo.services;

import com.example.reactiveDemo.entities.Todo;
import com.example.reactiveDemo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Flux<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Mono<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Mono<Todo> createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Mono<Void> deleteTodo(Long id) {
        return todoRepository.deleteById(id);
    }

    public Mono<Todo> updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(updatedTodo.getTitle());
                    existing.setCompleted(updatedTodo.getCompleted());
                    return todoRepository.save(existing);
                });
    }
}
