package io.github.educastrob.libraryapi.service;

import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }
}
