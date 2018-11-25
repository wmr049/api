package br.com.kroton.service

import br.com.kroton.domain.Email
import br.com.kroton.client.mail.MailClient
import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse

import javax.inject.Singleton

@Singleton
@CompileStatic
class EmailService {

    private final MailClient mailClient

    EmailService(MailClient mailClient) {
        this.mailClient = mailClient
    }

    HttpResponse sendEmail(Email email) {
        mailClient.send(email)
    }

    HttpResponse send(String email) {
        Email emailDTO = new Email()
        emailDTO.with {
            recipient = email
            subject = "Teste Envio de Serviço Api Gateway"
            textBody = "Testando envio de email via gateway"
        }
        mailClient.send(emailDTO)
    }
}