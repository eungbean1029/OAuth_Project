package com.eungbean.oauth_service.oAuth;

import java.util.Map;

public interface OAuth2LoginRequset {
    OAuth2Provider oAuth2Provider();
    Map<String,String> authorizationParams();
}
