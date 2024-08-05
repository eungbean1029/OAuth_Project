package com.eungbean.oauth_service.google.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record GoogleOAuth2Token(
        String accessToken,
        String tokenType,
        String refreshToken,
        String expiredDate
) {


}
