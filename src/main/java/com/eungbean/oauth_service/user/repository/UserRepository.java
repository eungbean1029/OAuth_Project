package com.eungbean.oauth_service.user.repository;

import com.eungbean.oauth_service.base.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findBySocialIdAndSocialType(String socialId, String socialType);
    User saveUser(User user);
}
