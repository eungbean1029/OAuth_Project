package com.eungbean.oauth_service.oAuth;

import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public interface BaseOAuth2UserInfo {
    String getId();
    String getEmail();
    String getName();
    Map<String, Object> getAttributes();

}

