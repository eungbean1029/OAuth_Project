package com.eungbean.oauth_service.google.dto;

import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public record GoogleOAuth2UserInfo(
        String id,
        String email,
        String name,
        Map<String, Object> attributes

) implements OAuth2UserInfo {

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        this(
                attributes.get("sub").toString(),
                attributes.get("email").toString(),
                attributes.get("name").toString(),
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
