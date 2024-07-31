package com.eungbean.oauth_service.oAuth.config;

import com.eungbean.oauth_service.oAuth.OAuth2ApiClient;
import com.eungbean.oauth_service.oAuth.OAuth2Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class OAuth2Config {
    /**
     * 파라미터가 어떤 리소스 서버에 대한 요청인지 구분
     */
    @Bean
    public Map<OAuth2Provider, OAuth2ApiClient> oAuth2ApiClientMap(List<OAuth2ApiClient> clients) {
        return clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuth2ApiClient::oAuth2Provider, Function.identity())
        );
    }
}
