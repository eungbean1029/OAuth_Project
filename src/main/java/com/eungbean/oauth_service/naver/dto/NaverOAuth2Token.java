package com.eungbean.oauth_service.naver.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record NaverOAuth2Token(
        String accessToken,
        String tokenType,
        String refreshToken,
        String expiredDate
) {


}
