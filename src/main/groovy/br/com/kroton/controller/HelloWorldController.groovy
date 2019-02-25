package br.com.kroton.controller

import br.com.kroton.client.hello.HelloClient
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
@Controller('/hello')
class HelloWorldController {
    
    private final HelloClient helloClient

    HelloWorldController(HelloClient helloClient) {
        this.helloClient = helloClient
    }

    @Get('/')
    @ContinueSpan
    HttpResponse download(String name){
        def result = helloClient.hello(name)
    }
}