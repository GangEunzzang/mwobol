package com.mwobol.domain.content.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContentType {

    WEBTOON("WT", "웹툰"),
    WEBNOVEL("WN", "웹소설");

    private final String code;
    private final String displayName;
}
