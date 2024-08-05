package com.eungbean.oauth_service.naver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.oauth2.client.registration.naver")
public record NaverOAuth2Config(
        String clientId,
        String clientSecret,
        String authorizationGrantType,
        String redirectUri,
        String tokenUri,
        String userInfoUri,
        String[] scope
) {

}
