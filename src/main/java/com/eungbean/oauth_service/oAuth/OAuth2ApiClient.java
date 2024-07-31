package com.eungbean.oauth_service.oAuth;

// AuthCode를 발급할 URL을 제공하는 인터페이스
public interface OAuth2ApiClient {
    OAuth2Provider oAuth2Provider();

    // AuthCode를 발급할 URL을 제공
    String getAuthorizationUrl();

    Object getAccessToken(OAuth2LoginRequset request);

    Object getUserInfo(String accessToken);
}
