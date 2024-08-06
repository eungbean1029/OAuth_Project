package com.eungbean.oauth_service.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Entity
@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String socialId;
    private String socialType;

}
