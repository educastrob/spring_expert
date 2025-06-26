package io.github.educastrob.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.valor1}")
    private String variavel;

    public void printVariavel() {
        System.out.println(variavel);
    }
}
