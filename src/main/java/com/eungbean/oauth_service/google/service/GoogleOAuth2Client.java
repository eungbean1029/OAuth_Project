package com.eungbean.oauth_service.google.service;

import com.eungbean.oauth_service.google.config.GoogleOAuth2Config;
import com.eungbean.oauth_service.google.dto.GoogleOAuth2Token;
import com.eungbean.oauth_service.google.dto.GoogleOAuth2UserInfo;
import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2Token;
import com.eungbean.oauth_service.kakao.dto.KakaoOAuth2UserInfo;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class GoogleOAuth2Client implements OAuth2ApiClient {

    private final GoogleOAuth2Config googleOAuth2Config;

    @Override
    public OAuth2Provider oAuth2Provider() {
        return OAuth2Provider.GOOGLE;
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
        params.put("client_id", googleOAuth2Config.clientId());
        params.put("client_secret", googleOAuth2Config.clientSecret());
        params.put("redirect_uri", googleOAuth2Config.redirectUri());
        params.put("grant_type", googleOAuth2Config.authorizationGrantType());

        GoogleOAuth2Token token = restTemplate.postForObject(googleOAuth2Config.tokenUri(), params, GoogleOAuth2Token.class);
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

        return restTemplate.postForObject(googleOAuth2Config.userInfoUri(), request, GoogleOAuth2UserInfo.class);

    }

    private HttpHeaders createUrlEncodedHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

}
