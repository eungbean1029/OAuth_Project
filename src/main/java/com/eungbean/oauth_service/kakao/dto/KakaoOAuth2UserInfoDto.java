package com.eungbean.oauth_service.kakao.dto;

import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record KakaoOAuth2UserInfoDto(
        String id,
        @JsonProperty("kakao_account")
        KaKaoAccountDto kaKaoAccountDto

) implements OAuth2UserInfo {
    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public OAuth2Provider getProvider() {
        return null;
    }
}
