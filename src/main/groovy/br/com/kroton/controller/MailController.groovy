package br.com.kroton.controller

import br.com.kroton.domain.Email
import br.com.kroton.service.EmailService
import groovy.transform.CompileStatic

import io.micronaut.health.HealthStatus
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue

import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;

@CompileStatic
@Controller('/mail')
class MailController {

    private final EmailService emailService

    MailController(EmailService emailService) {
        this.emailService = emailService
    }

    @Get('/health')
    HealthStatus health() {
        HealthStatus.UP
    }

    @Post(uri = '/send')
    @ContinueSpan
    HttpResponse send(@SpanTag("post.email") @QueryValue("email")String email){
        try{
            def retorno = emailService.send(email)
        }catch(Exception e){
            println(e.message)
        }
    }
}
