package io.github.educastrob.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);
        } catch (Exception e) {
            var message = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, message);
        }
    }

    @PostMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        this.service.atualizarStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPorId(@PathVariable("id") Integer id) {
        return this.service.buscarPorId(id);
    }
}
