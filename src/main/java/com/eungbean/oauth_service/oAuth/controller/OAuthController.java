package com.eungbean.oauth_service.oAuth.controller;


import com.eungbean.oauth_service.google.dto.GoogleOAuth2LoginRequestDto;
import com.eungbean.oauth_service.kakao.dto.KaKaoOAuth2LoginRequestDto;
import com.eungbean.oauth_service.naver.dto.NaverOAuth2LoginRequestDto;
import com.eungbean.oauth_service.oAuth.dto.OAuthLoginResponseDto;
import com.eungbean.oauth_service.oAuth.service.OAuthLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequiredArgsConstructor
@RestController("/oauth/api/v1")
public class OAuthController {

    private final OAuthLoginService oAuthLoginService;

    /**
     * oAuth2.0 카카오 로그인
     */
    @PostMapping("/login/kakao")
    public OAuthLoginResponseDto loginUser(@RequestBody KaKaoOAuth2LoginRequestDto request) {

        return oAuthLoginService.login(request);
    }

    /**
     * oAuth2.0 구글 로그인
     */
    @PostMapping("/login/google")
    public OAuthLoginResponseDto loginUser(@RequestBody GoogleOAuth2LoginRequestDto request) {

        return oAuthLoginService.login(request);
    }

    /**
     * oAuth2.0 네이버 로그인
     */
    @PostMapping("/login/naver")
    public OAuthLoginResponseDto loginUser(@RequestBody NaverOAuth2LoginRequestDto request) {

        return oAuthLoginService.login(request);
    }

    /**
     * oAuth2.0 회원가입
     */
    @PostMapping("/signup")
    public void signup() {
        // TODO : 회원가입 구현
        oAuthLoginService.signup();
    }

}
