package com.example.stargram.domain.user.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {

    public static final GlobalException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}