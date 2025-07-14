package io.github.educastrob.libraryapi.repository;

import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.model.GeneroLivro;
import io.github.educastrob.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarAutorELivroTest() {
        Livro livro = new Livro();
        livro.setIsbn("12498-98938");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("Tropa de Elipte");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = new Autor();
        autor.setNome("Joberto");
        autor.setNacionalidade("Fraces");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        autorRepository.save(autor);
        livro.setAutor(autor);
        repository.save(livro);
    }

    @Test
    void salvarCascadeTest(){
        Livro livro = new Livro();
        livro.setIsbn("84124-12343");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("O Pequeno Principe");
        livro.setDataPublicacao(LocalDate.of(2003, 8, 3));

        Autor autor = new Autor();
        autor.setNome("Roberto");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1987, 4, 14));

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void atualizarAutorDoLivro() {
        UUID id = UUID.fromString("081c6edd-3ef9-44e6-8a9a-927770dafbee");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("6241cfb8-3ffe-4909-8cf0-79831bc6ae9b");
        var amanda = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(amanda);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletar() {
        UUID id = UUID.fromString("6241cfb8-3ffe-4909-8cf0-79831bc6ae9b");
        repository.deleteById(id);
    }

    @Test
    void deletarCascade() {
        UUID id = UUID.fromString("6241cfb8-3ffe-4909-8cf0-79831bc6ae9b");
        repository.deleteById(id);
    }

    @Test
    @Transactional
    void buscarLivroTest() {
        UUID id = UUID.fromString("2f036261-76cf-425c-9589-a9f9c01a8ba3");
        Livro livro = repository.findById(id).orElse(null);
        System.out.println("Livro:");
        System.out.println(livro.getTitulo());

        System.out.println("Autor:");
        System.out.println(livro.getAutor().getNome());
    }

    @Test
    void pesquisaPorTituloTest() {
        List<Livro> lista = repository.findByTitulo("Chama no Esquenta");
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorIsbnTest() {
        List<Livro> lista = repository.findByIsbn("90887-84874");
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorTituloEPrecoTest() {
        var preco = BigDecimal.valueOf(204.00);
        var tituloPesquisa = "Chama no Esquenta";

        List<Livro> lista = repository.findByTituloAndPreco(tituloPesquisa, preco);
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorTituloOuIsbnTest() {
        var tituloPesquisa = "Chama no Esquenta";
        var isbn = "90887-84874";

        List<Livro> lista = repository.findByTituloOrIsbn(tituloPesquisa, isbn);
        lista.forEach(System.out::println);
    }

    @Test
    void listarLivrosComQueryJPQL() {
        var resultado = repository.listarTodosOrdenadoPorTituloAndPreco();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarAutoresDosLivros() {
        var resultado = repository.listarAutoresDosLivros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarTitulosNaoRepetidosDosLivros() {
        var resultado = repository.listarNomesDiferentesLivros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarGenerosDeLivrosAutoresBrasileiros() {
        var resultado = repository.listarGenerosAutoresBrasileiros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroQueryParamTest() {
        var resultado = repository.findByGeneroNamedParams(GeneroLivro.MISTERIO, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroPositionalParamTest() {
        var resultado = repository.findByGeneroPositionalParameters(GeneroLivro.MISTERIO, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void deletePorGeneroTest() {
        repository.deleteByGenero(GeneroLivro.FICCAO);
    }

    @Test
    void updateDataPublicacaoTest() {
        repository.updateDataPublicacao(LocalDate.of(2004, 4, 28));
    }
}