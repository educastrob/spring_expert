package io.github.educastrob.libraryapi.controller.dto;

import io.github.educastrob.libraryapi.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResultadoPesquisaLivroDTO(
        String isbn,
        String titulo,
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        AutorDTO autor
) {
}
