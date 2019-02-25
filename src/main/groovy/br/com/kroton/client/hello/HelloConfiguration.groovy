package br.com.kroton.client.hello

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires


@CompileStatic
@ConfigurationProperties(HelloConfiguration.PREFIX)
@Requires(property = HelloConfiguration.PREFIX)
class HelloConfiguration {
    public static final String PREFIX = "ksms"
    public static final String ID = "http://helloworld-service:8080/hello"

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
