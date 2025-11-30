package com.mwobol.domain.content.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlatformTest {

    @Test
    @DisplayName("플랫폼 목록 확인")
    void platforms() {
        assertThat(Platform.values()).containsExactlyInAnyOrder(
                Platform.NAVER_WEBTOON,
                Platform.KAKAO_PAGE,
                Platform.KAKAO_WEBTOON,
                Platform.NAVER_SERIES,
                Platform.RIDI
        );
    }

    @Test
    @DisplayName("플랫폼 코드")
    void code() {
        assertThat(Platform.NAVER_WEBTOON.getCode()).isEqualTo("NW");
        assertThat(Platform.KAKAO_PAGE.getCode()).isEqualTo("KP");
    }

    @Test
    @DisplayName("플랫폼 한글명")
    void displayName() {
        assertThat(Platform.NAVER_WEBTOON.getDisplayName()).isEqualTo("네이버웹툰");
        assertThat(Platform.KAKAO_PAGE.getDisplayName()).isEqualTo("카카오페이지");
    }
}
