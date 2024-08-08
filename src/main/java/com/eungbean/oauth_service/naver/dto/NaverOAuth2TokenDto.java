package com.eungbean.oauth_service.naver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record NaverOAuth2TokenDto(
        String accessToken,
        String tokenType,
        String refreshToken,
        String expiredDate
) {


}
