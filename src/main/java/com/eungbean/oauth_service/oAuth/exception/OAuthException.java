package com.eungbean.oauth_service.oAuth.exception;


import com.eungbean.oauth_service.base.exception.BaseException;

public class OAuthException extends BaseException {

    public OAuthException(String errorMessage) {
        super(errorMessage);
    }

    public OAuthException(String code, String errorMessage) {
        super(code, errorMessage);
    }
}
