package com.eungbean.oauth_service.oAuth;

public enum OAuth2Provider {
    KAKAO("kakao"),
    GOOGLE("google"),
    NAVER("naver");

    private final String provider;

    OAuth2Provider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public static OAuth2Provider fromValue(String provider) {
        return OAuth2Provider.valueOf(provider.toUpperCase());
    }
}
