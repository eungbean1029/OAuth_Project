package com.eungbean.oauth_service.naver.dto;

import com.eungbean.oauth_service.oAuth.OAuth2LoginRequset;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class NaverOAuth2LoginRequest implements OAuth2LoginRequset {

    private String authCode;

    @Override
    public OAuth2Provider oAuth2Provider() {
        return OAuth2Provider.NAVER;
    }

    @Override
    public Map<String, String> authorizationParams() {
        Map<String, String> request = new HashMap<>();
        request.put("code", authCode);
        return request;
    }
}
