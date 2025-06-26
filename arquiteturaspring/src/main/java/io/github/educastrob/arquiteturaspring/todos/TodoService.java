package io.github.educastrob.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mail) {
         this.repository = todoRepository;
         this.todoValidator = validator;
         this.mailSender = mail;
    }

    public TodoEntity salvar(TodoEntity todo) {
        todoValidator.validar(todo);
        return repository.save(todo);
    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Não foi concluído";
        mailSender.enviarEmail("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
