package com.eungbean.oauth_service.oAuth;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component

public class OAuth2CodeRequestUrlProviderComposite {
    private final Map<OAuth2Provider, OAuth2CodeRequestUrlProvider> mapping;

    public OAuth2CodeRequestUrlProviderComposite(Set<OAuth2CodeRequestUrlProvider> providers) {
        mapping = providers.stream()
                .collect(Collectors.toMap(OAuth2CodeRequestUrlProvider::oAuthProvider,
                        Function.identity()));
    }

    public String provide(OAuth2Provider provider) {
        return getProvider(provider).provide();
    }

    private OAuth2CodeRequestUrlProvider getProvider(OAuth2Provider provider) {
        return Optional.ofNullable(mapping.get(provider))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported provider: " + provider));
    }
}
