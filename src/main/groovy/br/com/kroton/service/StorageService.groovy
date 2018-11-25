package br.com.kroton.service

import br.com.kroton.client.storage.StorageClient
import groovy.transform.CompileStatic
import io.micronaut.http.HttpResponse

import javax.inject.Singleton

@Singleton
@CompileStatic
class StorageService {

    private final StorageClient storageClient

    StorageService(StorageClient storageClient) {
        this.storageClient = storageClient
    }

    HttpResponse download(String bucket, String name) {
        storageClient.download(bucket,name)
    }
}
