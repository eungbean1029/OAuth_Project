package com.eungbean.oauth_service.oAuth.service;

import com.eungbean.oauth_service.oAuth.OAuth2ApiClient;
import com.eungbean.oauth_service.oAuth.OAuth2LoginRequset;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthLoginService {
    // TODO : Google, Naver, Kakao OAuth2.0 로그인 구현
    private final Map<OAuth2Provider, OAuth2ApiClient> oAuth2ApiClientMap;


    public Object login(OAuth2LoginRequset request) {
        log.info("OAuth2LoginRequest : {}", request);
        OAuth2UserInfo oAuth2UserInfo = requestUserInfo(request);
        if (oAuth2UserInfo != null) {
            // TODO : 사용자 정보로 회원가입 및 로그인 처리
            return null;
        }
        return null;
    }

    private OAuth2UserInfo requestUserInfo(OAuth2LoginRequset request) {
        // TODO : OAuth2.0 사용자 정보 요청
        OAuth2ApiClient oAuth2ApiClient = oAuth2ApiClientMap.get(request.oAuth2Provider());
        String accessToken = oAuth2ApiClient.getAccessToken(request);

        return oAuth2ApiClient.getUserInfo(accessToken);
    }
}
