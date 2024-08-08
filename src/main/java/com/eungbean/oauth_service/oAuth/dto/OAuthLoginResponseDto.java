package com.eungbean.oauth_service.oAuth.dto;

import lombok.Builder;

@Builder
public record OAuthLoginResponseDto(
        String OAuthProviderType,
        String accessToken,
        String oAuthUserId,
        String oAuthUserEmail
) {
}
