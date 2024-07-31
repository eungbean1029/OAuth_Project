package com.eungbean.oauth_service.naver.dto;

import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;

import java.util.Map;

public record NaverOAuth2UserInfo(
        String id,
        String name,
        String email,
        Map<String, Object> attributes
) implements OAuth2UserInfo {
    public NaverOAuth2UserInfo(Map<String, Object> attributes) {
        this(
                attributes.get("id").toString(),
                attributes.get("name").toString(),
                attributes.get("email").toString(),
                attributes
        );
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
