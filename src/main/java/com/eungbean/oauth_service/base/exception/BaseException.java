package com.eungbean.oauth_service.base.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private String code;
    private final String message;

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.message = errorMessage;
    }

    public BaseException(String code, String errorMessage) {
        super(errorMessage);
        this.message = errorMessage;
        this.code = code;
    }
}
