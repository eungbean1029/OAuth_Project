package com.eungbean.oauth_service.google;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GoogleOAuth2Config {

    @Value("${spring.oauth2.client.registration.google.client-id}")
    String clientId;
    @Value("${spring.oauth2.client.registration.google.client-secret}")
    String clientSecret;
    @Value("${spring.oauth2.client.registration.google.redirect-uri}")
    String redirectUri;
    @Value("${spring.oauth2.client.registration.google.scope}")
    String[] scope;
}

