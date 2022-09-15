package com.example.stargram.global.exception;

import com.example.stargram.global.error.exception.ErrorCode;
import com.example.stargram.global.error.exception.GlobalException;

public class InvalidRoleException extends GlobalException {

    public static final GlobalException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
