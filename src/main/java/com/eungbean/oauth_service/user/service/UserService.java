package com.eungbean.oauth_service.user.service;
import com.eungbean.oauth_service.user.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findBySocialIdAndSocialType(String socialId, String socialType);
    User saveUser(User user);
    String generateToken(User user);

}
