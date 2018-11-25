package br.com.kroton.client.mail

import br.com.kroton.domain.Email

import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

import javax.validation.Valid

@CompileStatic
@Client(MailConfiguration.ID)
interface MailClient {
    //@Post('/api/${ksms.apiversion}/repos/${ksms.organization}/${ksms.repository}/packages')
    @Post('/v1/mail')
    HttpResponse send(@Valid @Body Email email)
}
