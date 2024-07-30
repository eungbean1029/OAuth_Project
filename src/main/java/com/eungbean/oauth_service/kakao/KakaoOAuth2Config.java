package com.eungbean.oauth_service.kakao;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Builder
public class KakaoOAuth2Config {
    // Kakao OAuth2 인증을 위한 설정값
    @Value("${spring.oauth2.client.registration.kakao.client-id}")
    String clientId;
    @Value("${spring.oauth2.client.registration.kakao.client-secret}")
    String clientSecret;
    @Value("${spring.oauth2.client.registration.kakao.redirect-uri}")
    String redirectUri;
    @Value("${spring.oauth2.client.registration.kakao.scope}")
    String[] scope;
}
