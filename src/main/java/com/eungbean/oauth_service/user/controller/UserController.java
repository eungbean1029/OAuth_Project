package com.eungbean.oauth_service.user.controller;

import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2LoginRequest;
import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2Token;
import com.eungbean.oauth_service.oAuth.service.OAuthLoginService;
import com.eungbean.oauth_service.user.domain.User;
import com.eungbean.oauth_service.user.service.UserService;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
        private final UserService userService;
        private final OAuthLoginService oAuthLoginService;

        @PostMapping("/login/kakao")
        public void loginUser(@RequestBody KaKaoOAuth2LoginRequest request) {
             log.info("KakaoOAuth2LoginRequest : {}", request);
            // TODO : Kakao OAuth2.0 로그인 구현
            Object token = oAuthLoginService.login(request);
        }

        @PostMapping("/signup")
        public void signup(@RequestBody User user) {
            // TODO : 회원가입 구현
        }

        @PostMapping("/logout")
        public void logout() {
            // TODO : 로그아웃 구현
        }
}
