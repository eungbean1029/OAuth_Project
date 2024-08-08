package com.eungbean.oauth_service.oAuth.service;

import com.eungbean.oauth_service.base.config.security.TokenProvider;
import com.eungbean.oauth_service.oAuth.OAuth2ApiClient;
import com.eungbean.oauth_service.oAuth.OAuth2LoginRequset;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import com.eungbean.oauth_service.oAuth.dto.OAuthLoginResponseDto;
import com.eungbean.oauth_service.oAuth.exception.OAuthException;
import com.eungbean.oauth_service.base.domain.User;
import com.eungbean.oauth_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthLoginService {
    private final UserRepository userRepository;
    private final Map<OAuth2Provider, OAuth2ApiClient> oAuth2ApiClientMap;
    private final TokenProvider tokenProvider;

    public OAuthLoginResponseDto login(OAuth2LoginRequset request) {
        log.info("OAuth2LoginRequest : {}", request);

        OAuth2UserInfo oAuth2UserInfo = requestOAuthUserInfo(request);

        User oAuthUser = userRepository.findBySocialIdAndSocialType(oAuth2UserInfo.getId(), oAuth2UserInfo.getProvider().getProvider())
                .orElseThrow(() -> new OAuthException("사용자 정보가 없습니다. 소셜 회원가입을 먼저 진행해주세요."));

        // Access Token 발급
        String accessToken = tokenProvider.createToken(oAuthUser.getEmail());

        return OAuthLoginResponseDto.builder()
                .OAuthProviderType(oAuth2UserInfo.getProvider().getProvider())
                .accessToken(accessToken)
                .oAuthUserId(oAuth2UserInfo.getId())
                .oAuthUserEmail(oAuth2UserInfo.getEmail())
                .build();
    }

    private OAuth2UserInfo requestOAuthUserInfo(OAuth2LoginRequset request) {
        // OAuth2.0 사용자 정보 요청
        OAuth2ApiClient oAuth2ApiClient = oAuth2ApiClientMap.get(request.oAuth2Provider());
        // Access Token 요청
        String accessToken = oAuth2ApiClient.getAccessToken(request);
        // 해당 AccessToken으로 사용자 정보 요청
        return oAuth2ApiClient.getUserInfo(accessToken);
    }

    private void saveUserInfo(OAuth2UserInfo oAuth2UserInfo) {
        User user = User.builder()
                .id(oAuth2UserInfo.getId())
                .email(oAuth2UserInfo.getEmail())
                .name(oAuth2UserInfo.getName())
                .socialId(oAuth2UserInfo.getProvider().getId())
                .socialType(oAuth2UserInfo.getProvider().getProvider())
                .build();
        userRepository.save(user);
    }

    public void signup() {
        // TODO : 회원가입 구현
    }


}
