package com.eungbean.oauth_service.google.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record GoogleOAuth2TokenDto(
        String accessToken,
        String tokenType,
        String refreshToken,
        String expiredDate
) {


}
