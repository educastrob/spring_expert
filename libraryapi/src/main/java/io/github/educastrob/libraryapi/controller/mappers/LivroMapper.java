package io.github.educastrob.libraryapi.controller.mappers;

import io.github.educastrob.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.educastrob.libraryapi.model.Livro;
import io.github.educastrob.libraryapi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(CadastroLivroDTO dto);
}
