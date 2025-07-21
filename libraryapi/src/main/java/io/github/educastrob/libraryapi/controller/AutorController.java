package io.github.educastrob.libraryapi.controller;

import io.github.educastrob.libraryapi.controller.dto.AutorDTO;
import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.repository.AutorRepository;
import io.github.educastrob.libraryapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autores")
// http://localhost:8080/autores
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AutorDTO autor) {
        Autor autorEntidade = autor.mapearParaAutor();
        service.salvar(autorEntidade);
        return new ResponseEntity("Autor salvo com sucesso! " + autor, HttpStatus.CREATED);
    }

}
