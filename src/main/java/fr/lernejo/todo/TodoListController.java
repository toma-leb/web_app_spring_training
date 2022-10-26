package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/todo")
public record TodoListController (TodoRepository todos) {

    @PostMapping
    public void addTodo(@RequestBody TodoEntity todo) {
        todos.save(todo);
    }

    @GetMapping
    Iterable<TodoEntity> getTodos() {
        return todos.findAll();
    }
    @DeleteMapping
    public void removeTodo() {
        todos.deleteAll();
    }

}
