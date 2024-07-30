package com.eungbean.oauth_service.kakao;

import com.eungbean.oauth_service.oAuth.OAuth2CodeRequestUrlProvider;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
public class KakaoOAuth2CodeRequestUrlProvider implements OAuth2CodeRequestUrlProvider {

    private final KakaoOAuth2Config kakaoOAuth2Config;
    private final ClientRegistrationRepository clientRegistrationRepository;

    @Override
    public OAuth2Provider oAuthProvider() {
        return OAuth2Provider.KAKAO;
    }

    @Override
    public String getAuthorizationUrl() {
        return UriComponentsBuilder
                .fromUriString("https://kauth.kakao.com/oauth/authorize")
                .queryParam("client_id", kakaoOAuth2Config.getClientId())
                .queryParam("redirect_uri", kakaoOAuth2Config.getRedirectUri())
                .queryParam("response_type", "code")
                .queryParam("scope", String.join(",", kakaoOAuth2Config.getScope()))
                .build()
                .toUriString();
    }

    @Override
    public String getAccessToken(String code, String registrationId) {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(oAuthProvider().toString());
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = clientRegistration.getProviderDetails().getTokenUri();
        Map<String,String> params = Map.of(
                "grant_type", "authorization_code",
                "code", code,
                "client_id", kakaoOAuth2Config.getClientId(),
                "client_secret", kakaoOAuth2Config.getClientSecret(),
                "redirect_uri", kakaoOAuth2Config.getRedirectUri()
        );
        return Objects.requireNonNull(restTemplate.postForObject(tokenUrl, params, Map.class)).get("access_token").toString();
    }

    @Override
    public Map<String, Object> getUserInfo(String accessToken, String registrationId) {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(oAuthProvider().toString());
        RestTemplate restTemplate = new RestTemplate();
        String userInfoUrl = clientRegistration.getProviderDetails().getUserInfoEndpoint().getUri();
        return restTemplate.getForObject(userInfoUrl + "?access_token=" + accessToken, Map.class);
    }

}
