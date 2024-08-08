package com.eungbean.oauth_service.google.dto;

import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public record GoogleOAuth2UserInfoDto(
        String id,
        String email,
        String nickname
) implements OAuth2UserInfo {

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
        return nickname;
    }

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.GOOGLE;
    }

}
