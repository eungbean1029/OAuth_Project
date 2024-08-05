package com.eungbean.oauth_service.naver.dto;

import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import com.eungbean.oauth_service.oAuth.OAuth2UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public record NaverOAuth2UserInfo(
        @JsonProperty("response")
        Response response
) implements OAuth2UserInfo {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        private String id;
        private String email;
        private String name;
    }
    @Override
    public String getId() {
        return response().id;
    }

    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getName() {
        return response.name;
    }

    @Override
    public OAuth2Provider getProvider() {
        return OAuth2Provider.NAVER;
    }

}


