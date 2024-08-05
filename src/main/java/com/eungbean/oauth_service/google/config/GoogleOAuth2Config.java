package com.eungbean.oauth_service.google.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.oauth2.client.registration.google")
public record GoogleOAuth2Config(
        String clientId,
        String clientSecret,
        String authorizationGrantType,
        String redirectUri,
        String tokenUri,
        String userInfoUri,
        String[] scope
) {

}
