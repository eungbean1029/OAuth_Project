package com.eungbean.oauth_service.user.dto;

import lombok.Builder;

@Builder
public record UserLoginResponse(
        String accessToken,
        String tokenType,
        Long expiresIn
) {
}
