package io.github.educastrob.libraryapi.controller;

import io.github.educastrob.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.educastrob.libraryapi.controller.dto.ErroResposta;
import io.github.educastrob.libraryapi.controller.mappers.LivroMapper;
import io.github.educastrob.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.educastrob.libraryapi.model.Livro;
import io.github.educastrob.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto) {
        try {
            Livro livro = mapper.toEntity(dto);
            service.salvar(livro);
            URI url = gerarHeaderLocation(livro.getId());
            return ResponseEntity.created(url).build();
        } catch (RegistroDuplicadoException e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}
