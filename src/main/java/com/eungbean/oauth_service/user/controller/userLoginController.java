package com.eungbean.oauth_service.user.controller;

import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2LoginRequest;
import com.eungbean.oauth_service.user.dto.UserLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class userLoginController {
    @PostMapping("/login/kakao")
    public UserLoginResponse loginKakao(@RequestBody KaKaoOAuth2LoginRequest params) {

        log.info("[UserPublicApiController] KakaoLoginParams : {} ", params.authorizationParams());
        return null;
//        return oAuth2LoginService.login(params);

    }
}
