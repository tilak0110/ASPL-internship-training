package com.example.Tudu.controllers;

import com.example.Tudu.dto.TodoDto;
import com.example.Tudu.entities.Todo;
import com.example.Tudu.entities.User;
import com.example.Tudu.services.TodoService;
import com.example.Tudu.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/todo")
@Tag(name = "Todo Controller", description = "Handles all Todo-related operations")

public class TodoController {
//    TodoService todoService;
//    UserService userService;

//    @Autowired
//    public TodoController(TodoService todoService , UserService userService){
//        this.todoService=todoService;
//        this.userService=userService;
//    }
//    @GetMapping("/{userId}")
//    public ResponseEntity<?> getTodoByUserId(@PathVariable("userId") long id){
//        Optional<User> user=userService.findById(id);
//        if(user.isPresent()){
//            return ResponseEntity.status(HttpStatus.FOUND).body(todoService.getTodoByUserId(id));
//        }else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id : "+id);
//        }
//    }
//
//    @PostMapping("/{userId}")
//    public ResponseEntity<?> addTodo(@PathVariable("userId") long id, @RequestBody Todo todo){
//        Optional<User> optionalUser= userService.findById(id);
//        if(optionalUser.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id : "+id);
//        }
//        todo.setUser(optionalUser.get());
//        Todo savedTodo = todoService.addTodoForUser(todo);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
//    }
//    @PutMapping("/{todoId}")
//    public ResponseEntity<?> updateTodoStatus(@PathVariable ("todoId") long id)

//---------------------------------------------------------------------------------------------------------------------------
    

	    private final TodoService todoService;

	    @Autowired
	    public TodoController(TodoService todoService) {
	        this.todoService = todoService;
	    }

	    @Operation(summary = "Get all todos for a user")
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<TodoDto>> getTodosByUser(@PathVariable Long userId) {
	        return ResponseEntity.ok(todoService.getTodoByUserId(userId));
	    }

	    @Operation(summary = "Add a new todo for a user")
	    @PostMapping("/{userId}")
	    public ResponseEntity<TodoDto> addTodo(@PathVariable Long userId, @RequestBody TodoDto todoDto) {
	        return ResponseEntity.ok(todoService.addTodoForUser(userId, todoDto));
	    }

	    @Operation(summary = "Update an existing todo")
	    @PutMapping("/{todoId}")
	    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long todoId, @RequestBody TodoDto dto) {
	        return ResponseEntity.ok(todoService.updateTodo(todoId, dto));
	    }

	    @Operation(summary = "Delete a todo")
	    @DeleteMapping("/{todoId}")
	    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
	        todoService.deleteTodo(todoId);
	        return ResponseEntity.noContent().build();
	    }

	    @Operation(summary = "Get a todo by its ID")
	    @GetMapping("/{todoId}")
	    public ResponseEntity<TodoDto> getTodo(@PathVariable Long todoId) {
	        return ResponseEntity.ok(todoService.getTodoById(todoId));
	    }

	    @Operation(summary = "Mark a todo as completed")
	    @PatchMapping("/{todoId}/complete")
	    public ResponseEntity<TodoDto> completeTodo(@PathVariable Long todoId) {
	        return ResponseEntity.ok(todoService.markAsCompleted(todoId));
	    }
	}