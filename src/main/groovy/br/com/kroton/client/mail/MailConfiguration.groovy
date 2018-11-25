package br.com.kroton.client.mail

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires


@CompileStatic
@ConfigurationProperties(MailConfiguration.PREFIX)
@Requires(property = MailConfiguration.PREFIX)
class MailConfiguration {
    public static final String PREFIX = "ksms"
    public static final String ID = "messenger-service"

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
