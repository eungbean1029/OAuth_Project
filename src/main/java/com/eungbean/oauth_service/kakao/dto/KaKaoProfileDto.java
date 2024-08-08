package com.eungbean.oauth_service.kakao.dto;

import lombok.Builder;

@Builder
public record KaKaoProfileDto(
        String nickname
) {
}
