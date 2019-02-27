package br.com.kroton.client.storage

import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@CompileStatic
@Client(StorageConfiguration.ID)
interface StorageClient{
    @Post('/storage/download')
    HttpResponse download(String bucket, String name)
}