package br.com.kroton.client.storage

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@CompileStatic
@ConfigurationProperties(StorageConfiguration.PREFIX)
@Requires(property = StorageConfiguration.PREFIX)
class StorageConfiguration{
    public static final String PREFIX = "ksms"
    public static final String ID = "http://storage-service:8084"

    String apiversion
    String organization
    String repository
    String username
    String token

    Map<String, Object> toMap() {
        [
                apiversion: apiversion,
                organization: organization,
                repository: repository,
                username: username,
                token: token
        ] as Map<String, Object>
    }
}