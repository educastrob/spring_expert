package io.github.educastrob.arquiteturaspring;

import io.github.educastrob.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("url");
//        dataSource.setUsername("user");
//        dataSource.setPassword("password");
//
//        Connection connection = dataSource.getConnection();
//        EntityManager entityManager = null;
//
//        TodoRepository todoRepository = new SimpleJpaRepository<TodoEntity, Integer>(null, null);
//        TodoValidator todoValidator = new TodoValidator(todoRepository);
//        MailSender todoSender = new MailSender();
//
//        TodoService todoService = new TodoService(todoRepository, todoValidator, todoSender);

//        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
//        beanGerenciado.setValidator(todoValidator);
//        if (condicao == true) {
//            beanGerenciado.setValidator(todoValidator);
//        }
    }
}
