package com.eungbean.oauth_service.kakao.dto;

import com.eungbean.oauth_service.oAuth.BaseOAuth2UserInfo;

import java.util.Map;

public record KakaoOAuth2UserInfo(
        String id,
        String name,
        String email,
        String profileImage,
        Map<String, Object> attributes

) implements BaseOAuth2UserInfo {

        public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
            this(
                    attributes.get("id").toString(),
                    attributes.get("properties").toString(),
                    attributes.get("kakao_account").toString(),
                    attributes.get("profile_image").toString(),
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
