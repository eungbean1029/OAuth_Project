package com.eungbean.oauth_service.kakao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.oauth2.client.registration.kakao")
public record KakaoOAuth2Config(
        String clientId,
        String clientSecret,
        String authorizationGrantType,
        String redirectUri,
        String tokenUri,
        String userInfoUri,
        String[] scope
) {

}
