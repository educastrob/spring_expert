package io.github.educastrob.libraryapi.controller.mappers;

import io.github.educastrob.libraryapi.controller.dto.AutorDTO;
import io.github.educastrob.libraryapi.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
