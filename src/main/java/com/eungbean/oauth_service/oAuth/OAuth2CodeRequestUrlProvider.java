package com.eungbean.oauth_service.oAuth;

import java.util.Map;

// AuthCode를 발급할 URL을 제공하는 인터페이스
public interface OAuth2CodeRequestUrlProvider {
    OAuth2Provider oAuthProvider();

    // AuthCode를 발급할 URL을 제공
    String getAuthorizationUrl();

    String getAccessToken(String code, String registrationId);

    Map<String, Object> getUserInfo(String accessToken, String registrationId);
}
