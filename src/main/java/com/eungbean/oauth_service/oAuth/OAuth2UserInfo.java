package com.eungbean.oauth_service.oAuth;

public interface OAuth2UserInfo {
    String getId();
    String getEmail();
    String getName();
    OAuth2Provider getProvider();
}

