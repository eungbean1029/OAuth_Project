package com.eungbean.oauth_service.user.service;

import com.eungbean.oauth_service.base.domain.User;
import com.eungbean.oauth_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public Optional<User> findBySocialIdAndSocialType(String socialId, String socialType) {
        return userRepository.findBySocialIdAndSocialType(socialId, socialType);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String generateToken(User user) {
        //Jwt 토큰 생성
        return null;
    }
}
