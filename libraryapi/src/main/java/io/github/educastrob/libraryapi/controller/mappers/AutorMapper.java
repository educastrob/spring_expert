package io.github.educastrob.libraryapi.controller.mappers;

import io.github.educastrob.libraryapi.controller.dto.AutorDTO;
import io.github.educastrob.libraryapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
