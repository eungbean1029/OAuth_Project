package com.eungbean.oauth_service.oAuth;

public enum OAuth2Provider {
    KAKAO("kakao" , "1"),
    GOOGLE("google", "2"),
    NAVER("naver", "3");


    private final String provider;
    private final String id;

    OAuth2Provider(String provider, String id) {
        this.provider = provider;
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public String getId() {
        return id;
    }

    public static OAuth2Provider fromvalue(String provider) {
        return OAuth2Provider.valueOf(provider.toUpperCase());
    }
}
