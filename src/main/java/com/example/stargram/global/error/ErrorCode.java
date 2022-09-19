package com.example.stargram.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_PASSWORD(401,"USER-4o1-1", "Invalid Passowrd"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    INVALID_ROLE(401, "GLOBAL-401-1", "Invalid Role"),
    FEED_NOT_FOUND(404, "FEED-404-1", "Feed Not Found");
    private final int status;
    private final String code;
    private final String message;
}
