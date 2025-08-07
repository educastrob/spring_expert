package io.github.educastrob.libraryapi.service;

import io.github.educastrob.libraryapi.model.Livro;
import io.github.educastrob.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    @Autowired
    private final LivroRepository repository;

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }
}
