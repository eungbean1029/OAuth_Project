package com.eungbean.oauth_service.naver.service;

import com.eungbean.oauth_service.google.dto.GoogleOAuth2Token;
import com.eungbean.oauth_service.google.dto.GoogleOAuth2UserInfo;
import com.eungbean.oauth_service.naver.config.NaverOAuth2Config;
import com.eungbean.oauth_service.naver.dto.NaverOAuth2Token;
import com.eungbean.oauth_service.naver.dto.NaverOAuth2UserInfo;
import com.eungbean.oauth_service.oAuth.OAuth2ApiClient;
import com.eungbean.oauth_service.oAuth.OAuth2LoginRequset;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class NaverOAuth2Client implements OAuth2ApiClient {

    private final NaverOAuth2Config naverOAuth2Config;

    @Override
    public OAuth2Provider oAuth2Provider() {
        return OAuth2Provider.NAVER;
    }

//    @Override
//    public String getAuthorizationUrl() {
//        return UriComponentsBuilder
//                .fromUriString("https://kauth.kakao.com/oauth/authorize")
//                .queryParam("client_id", googleOAuth2Config.clientId())
//                .queryParam("redirect_uri", googleOAuth2Config.redirectUri())
//                .queryParam("response_type", "code")
//                .queryParam("scope", String.join(",", googleOAuth2Config.scope()))
//                .build()
//                .toUriString();
//    }

    // Authorization Code를 이용하여 Access Token을 발급받는 메소드
    @Override
    public String getAccessToken(OAuth2LoginRequset request) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = request.authorizationParams();
        params.put("client_id", naverOAuth2Config.clientId());
        params.put("client_secret", naverOAuth2Config.clientSecret());
        params.put("redirect_uri", naverOAuth2Config.redirectUri());
        params.put("grant_type", naverOAuth2Config.authorizationGrantType());

        NaverOAuth2Token token = restTemplate.postForObject(naverOAuth2Config.tokenUri(), params, NaverOAuth2Token.class);
        if (Objects.isNull(token)) {
            throw new RuntimeException("Failed to get access token");
        }

        return token.getAccessToken();
    }

    @Override
    public OAuth2UserInfo getUserInfo(String accessToken) {
        // header
        HttpHeaders httpHeaders = createUrlEncodedHttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + accessToken);
        log.info("Authorization: " + "Bearer "+ accessToken);
        // request
        HttpEntity<?> request = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(naverOAuth2Config.userInfoUri(), request, NaverOAuth2UserInfo.class);

    }

    private HttpHeaders createUrlEncodedHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

}
