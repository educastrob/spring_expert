package io.github.educastrob.libraryapi.service;

import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.model.GeneroLivro;
import io.github.educastrob.libraryapi.model.Livro;
import io.github.educastrob.libraryapi.repository.AutorRepository;
import io.github.educastrob.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;


    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository
                .findById(UUID.fromString("081c6edd-3ef9-44e6-8a9a-927770dafbee"))
                .orElse(null);
        livro.setDataPublicacao(LocalDate.of(2024, 6, 24));
        livroRepository.save(livro);
    }

    @Transactional
    public void executar() {
        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Joberto");
        autor.setNacionalidade("Fraces");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        autorRepository.save(autor);

        // salva o livro
        Livro livro = new Livro();
        livro.setIsbn("12498-98938");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("Tropa de Elipte");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if (autor.getNome().equals("Maria")) {
            throw new RuntimeException("Rollback!");
        }
    }
}
