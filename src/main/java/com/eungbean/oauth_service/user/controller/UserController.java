package com.eungbean.oauth_service.user.controller;

import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2LoginRequestDto;
import com.eungbean.oauth_service.oAuth.service.OAuthLoginService;
import com.eungbean.oauth_service.base.domain.User;
import com.eungbean.oauth_service.user.service.UserService;
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

        @PostMapping
        public void login(@RequestBody KaKaoOAuth2LoginRequestDto request) {
            // TODO : 로그인 구현
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
