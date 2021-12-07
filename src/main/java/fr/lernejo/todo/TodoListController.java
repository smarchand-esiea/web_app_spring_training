package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {
    TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping(value = "/api/todo")
    public void AjoutTodo(@RequestBody Todo todo) {
        TodoEntity todoEntity = new TodoEntity(null, todo.message(), todo.author());
        todoRepository.save(todoEntity);
    }

    @GetMapping(value = "/api/todo")
    public Iterable<TodoEntity> GetTodo() {
        return todoRepository.findAll();
    }
}
