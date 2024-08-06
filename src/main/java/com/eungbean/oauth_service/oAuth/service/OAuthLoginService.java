package com.eungbean.oauth_service.oAuth.service;

import com.eungbean.oauth_service.base.config.security.TokenProvider;
import com.eungbean.oauth_service.oAuth.OAuth2ApiClient;
import com.eungbean.oauth_service.oAuth.OAuth2LoginRequset;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import com.eungbean.oauth_service.user.domain.User;
import com.eungbean.oauth_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthLoginService {
    private final UserRepository userRepository;
    // TODO : Google, Naver, Kakao OAuth2.0 로그인 구현
    private final Map<OAuth2Provider, OAuth2ApiClient> oAuth2ApiClientMap;
    private final TokenProvider tokenProvider;


    public Object login(OAuth2LoginRequset request) {
        log.info("OAuth2LoginRequest : {}", request);
        OAuth2UserInfo oAuth2UserInfo = requestUserInfo(request);
        if (oAuth2UserInfo != null) {
            // User 정보 저장
            User user = User.builder()
                    .id(oAuth2UserInfo.getId())
                    .email(oAuth2UserInfo.getEmail())
                    .name(oAuth2UserInfo.getName())
                    .socialId(oAuth2UserInfo.getProvider().getId())
                    .socialType(oAuth2UserInfo.getProvider().getProvider())
                    .build();
            userRepository.save(user);

            // Token 발급
            tokenProvider.createToken(oAuth2UserInfo.getEmail());
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
