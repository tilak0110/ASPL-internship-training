package com.example.Tudu.services;

import java.util.List;


import com.example.Tudu.dto.TodoDto;

public interface TodoService {
    TodoDto addTodoForUser(Long userId , TodoDto todoDto);

    List<TodoDto> getTodoByUserId(long userid);
    
    TodoDto getTodoById (Long todoId) ;
    
    TodoDto updateTodo(Long todoId, TodoDto todoDto);
    
    void deleteTodo(Long todoId);
    
    TodoDto markAsCompleted(Long todoId);

    long deleteCompletedTodosByUserId(Long userId);
}
