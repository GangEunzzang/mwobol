package com.mwobol.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C001", "서버 오류가 발생했습니다"),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "C002", "잘못된 입력입니다"),

    // Content
    CONTENT_NOT_FOUND(HttpStatus.NOT_FOUND, "CT001", "작품을 찾을 수 없습니다"),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "사용자를 찾을 수 없습니다"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "U002", "인증이 필요합니다"),

    // Review
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "R001", "리뷰를 찾을 수 없습니다"),
    REVIEW_ALREADY_EXISTS(HttpStatus.CONFLICT, "R002", "이미 리뷰를 작성했습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
