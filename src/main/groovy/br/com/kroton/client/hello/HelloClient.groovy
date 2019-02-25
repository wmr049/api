package br.com.kroton.client.hello

import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@CompileStatic
@Client(StorageConfiguration.ID)
interface HelloClient{
    @Post('/')
    HttpResponse hello(String name)
}