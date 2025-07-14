package io.github.educastrob.libraryapi.repository;

import io.github.educastrob.libraryapi.model.Autor;
import io.github.educastrob.libraryapi.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    private TransacaoService transacaoService;

    /**
    * Commit -> confirmar as alterações
    * Rollback -> desfazer as alterações
    */

    @Test
    void transacaoSimples() {
        transacaoService.executar();
    }

    @Test
    void transacaoEstadoManaged() {
        transacaoService.atualizacaoSemAtualizar();
    }
}
