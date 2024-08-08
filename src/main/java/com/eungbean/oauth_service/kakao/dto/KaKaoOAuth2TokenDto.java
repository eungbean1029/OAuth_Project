package com.eungbean.oauth_service.kakao.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record KaKaoOAuth2TokenDto(
        String accessToken,
        String tokenType,
        String refreshToken,
        String expiredDate
) {


}
