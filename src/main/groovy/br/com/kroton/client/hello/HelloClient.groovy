package br.com.kroton.client.hello

import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@CompileStatic
@Client(HelloConfiguration.ID)
interface HelloClient{
    @Get('/')
    HttpResponse hello(String name)
}