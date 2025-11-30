package com.mwobol.domain.content.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Platform {

    NAVER_WEBTOON("NW", "네이버웹툰"),
    KAKAO_PAGE("KP", "카카오페이지"),
    KAKAO_WEBTOON("KW", "카카오웹툰"),
    NAVER_SERIES("NS", "네이버시리즈"),
    RIDI("RD", "리디");

    private final String code;
    private final String displayName;
}
