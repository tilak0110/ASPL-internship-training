package com.example.reactiveDemo.repositories;

import com.example.reactiveDemo.entities.Todo;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class TodoRepository {

    // Simulating a database with an in-memory list
    private List<Todo> todoList = new ArrayList<>();

    public Flux<Todo> findAll() {
        return Flux.fromIterable(todoList);
    }

    public Mono<Todo> findById(Long id) {
        Optional<Todo> todo = todoList.stream().filter(t -> t.getId().equals(id)).findFirst();
        return Mono.justOrEmpty(todo);
    }

    public Mono<Todo> save(Todo todo) {
        todoList.add(todo);
        return Mono.just(todo);
    }

    public Mono<Void> deleteById(Long id) {
        todoList.removeIf(t -> t.getId().equals(id));
        return Mono.empty();
    }
}