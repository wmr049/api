package br.com.kroton.controller

import br.com.kroton.service.StorageService
import groovy.transform.CompileStatic
import io.micronaut.health.HealthStatus
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.tracing.annotation.ContinueSpan
import io.micronaut.tracing.annotation.SpanTag

@CompileStatic
@Controller('/storage')
class StorageController {

    private final StorageService storageService

    StorageController(StorageService storageService) {
        this.storageService = storageService
    }

    @Get('/health')
    HealthStatus health() {
        HealthStatus.UP
    }

    @Post('/download')
    @ContinueSpan
    HttpResponse download(@SpanTag("post.storage") String bucket, String name){
        def result = storageService.download(bucket, name)
    }
}
