package com.example.stargram.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_JWT(401, "COMMON-401-1", "Expired Jwt"),
    INVALID_JWT(401, "COMMON-401-2", "Invalid Jwt"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    EXPIRED_ACCESS_TOKEN(401, "AUTH-401-1","Expired Access Token"),
    EXPIRED_REFRESH_TOKEN(401,"AUTH-401-1","Expired Refresh Token"),
    INVALID_ROLE(401, "GLOBAL-401-1", "Invalid Role"),
    INVALID_TOKEN(401,"AUTH-401-1","Invalid Token"),
    INCORRECT_TOKEN(500,"AUTH-500-1","Incrrect Token"),
    INVALID_PASSWORD(401,"USER-4o1-1", "Invalid Passowrd"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    FEED_NOT_FOUND(404, "FEED-404-1", "Feed Not Found");
    private final int status;
    private final String code;
    private final String message;
}