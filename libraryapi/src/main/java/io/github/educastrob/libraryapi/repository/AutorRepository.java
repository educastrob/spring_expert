package io.github.educastrob.libraryapi.repository;

import io.github.educastrob.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Component
@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
