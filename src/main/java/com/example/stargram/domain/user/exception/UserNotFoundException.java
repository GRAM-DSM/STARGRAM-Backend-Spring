package com.example.stargram.domain.user.exception;

import com.example.stargram.global.error.ErrorCode;
import com.example.stargram.global.error.exception.SnsException;

public class UserNotFoundException extends SnsException {

    public static final SnsException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}