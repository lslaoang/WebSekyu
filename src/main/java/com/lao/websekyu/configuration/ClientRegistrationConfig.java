package com.lao.websekyu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ClientRegistrationConfig {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    String googleRegistrationId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    String googleRegistrationSecret;

    @Bean
    public ClientRegistrationRepository clientRepository() {
        ClientRegistration googleRegistration =
                CommonOAuth2Provider.GOOGLE.getBuilder("google")
                        .clientId(googleRegistrationId)
                        .clientSecret(googleRegistrationSecret)
                        .build();

        return new InMemoryClientRegistrationRepository(googleRegistration);
    }
}
