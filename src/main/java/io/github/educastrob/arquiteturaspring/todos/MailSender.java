package io.github.educastrob.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviarEmail(String email) {
        System.out.println("Enviado email: " + email);
    }
}
