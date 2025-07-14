package io.github.educastrob.libraryapi.repository;

import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.model.GeneroLivro;
import io.github.educastrob.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Eduardo Castro");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2004, 04, 28));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("342ae294-7007-4013-8c41-b6109e365102");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setNome("José");
            autorEncontrado.setDataNascimento(LocalDate.of(1942, 1, 30));

            repository.save(autorEncontrado);
        }

        System.out.println(possivelAutor.get());
    }

    @Test
    public void listarTest() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("06902792-0dba-415d-875d-e39b5b82401b");
        repository.deleteById( id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("f5e6294b-e050-4978-a96c-dda456f3d8bf");
        Autor eduardo = repository.findById(id).get();
        repository.delete(eduardo);
    }

    @Test
    void salvarAutorComLivrosTest() {
        Autor autor = new Autor();
        autor.setNome("Jasmin");
        autor.setNacionalidade("Alemã");
        autor.setDataNascimento(LocalDate.of(2001, 4, 14));

        Livro livro = new Livro();
        livro.setIsbn("74124-12743");
        livro.setPreco(BigDecimal.valueOf(178));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("O roubo da casa assombrada");
        livro.setDataPublicacao(LocalDate.of(2014, 8, 3));

        Livro livro2 = new Livro();
        livro.setIsbn("34124-52743");
        livro.setPreco(BigDecimal.valueOf(56.98));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setTitulo("Jonas sem Braço");
        livro.setDataPublicacao(LocalDate.of(2011, 8, 3));

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
    }

    @Test
    @Transactional
    void listarLivrosAutor() {
        var id = UUID.fromString("8f7b6f77-6155-41da-b328-df784db93014");
        var autor = repository.findById(id).get();

        var livrosLista = livroRepository.findByAutor(autor);
        autor.setLivros(livrosLista);
        autor.getLivros().forEach(System.out::println);
    }
}
