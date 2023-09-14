package com.app.session.exception;

import com.app.session.constant.ErrorCode;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED.getMessage());
    }

    public LoginFailedException(String message) {
        super(message);
    }
}
