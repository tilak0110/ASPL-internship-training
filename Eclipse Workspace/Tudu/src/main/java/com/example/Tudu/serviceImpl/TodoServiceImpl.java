package com.example.Tudu.serviceImpl;

import com.example.Tudu.dto.TodoDto;
import com.example.Tudu.entities.Todo;
import com.example.Tudu.entities.User;
import com.example.Tudu.repositories.TodoRepository;
import com.example.Tudu.repositories.UserRepository;
import com.example.Tudu.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("dev")
public class TodoServiceImpl implements TodoService {
	
	 private final TodoRepository todoRepository;
	 private final UserRepository userRepository;
	 
	 @Autowired
	 public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
	    this.todoRepository = todoRepository;
	    this.userRepository = userRepository;
	  }
	 
	 private TodoDto convertToDto(Todo todo) {
	        TodoDto dto = new TodoDto();
	        dto.setId(todo.getId());
	        dto.setTitle(todo.getTitle());
	        dto.setDescription(todo.getDescription());
	        dto.setCompleted(todo.isCompleted());
	        dto.setCreatedAt(todo.getCreatedAt());
	        dto.setDueDate(todo.getDueDate());
	        dto.setUserId(todo.getUser().getId());
	        return dto;
	    }


	@Override
	public TodoDto addTodoForUser(Long userId, TodoDto todoDto) {
		Optional<User> useropt = userRepository.findById(userId);
		if(useropt.isEmpty()) throw new RuntimeException("user ni mila");
		Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(false);
        todo.setDueDate(todoDto.getDueDate());
        todo.setUser(useropt.get());
        Todo saved = todoRepository.save(todo);
        return convertToDto(saved);
	}

	@Override
	public List<TodoDto> getTodoByUserId(long userid) {
	return todoRepository.findAllByUserId(userid).stream()
			.map(this::convertToDto)
			.collect(Collectors.toList());
	}

	@Override
	public TodoDto getTodoById(Long todoId) {
		 Todo todo = todoRepository.findById(todoId)
	                .orElseThrow(() -> new RuntimeException("Todo not found"));
	        return convertToDto(todo);
	}

	@Override
	public TodoDto updateTodo(Long todoId, TodoDto todoDto) {
		 Todo todo = todoRepository.findById(todoId)
	                .orElseThrow(() -> new RuntimeException("Todo not found"));

	        todo.setTitle(todoDto.getTitle());
	        todo.setDescription(todoDto.getDescription());
	        todo.setDueDate(todoDto.getDueDate());
	        todo.setCompleted(todoDto.isCompleted());

	        return convertToDto(todoRepository.save(todo));
	}

	@Override
	public void deleteTodo(Long todoId) {
		if (!todoRepository.existsById(todoId)) throw new RuntimeException("Todo not found");
        todoRepository.deleteById(todoId);
    }

	@Override
	public TodoDto markAsCompleted(Long todoId) {
		Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(true);
        return convertToDto(todoRepository.save(todo));
    }

   
}
