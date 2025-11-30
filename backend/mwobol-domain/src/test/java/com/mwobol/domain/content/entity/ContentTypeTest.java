package com.mwobol.domain.content.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContentTypeTest {

    @Test
    @DisplayName("콘텐츠 타입 목록")
    void contentTypes() {
        assertThat(ContentType.values()).containsExactlyInAnyOrder(
                ContentType.WEBTOON,
                ContentType.WEBNOVEL
        );
    }

    @Test
    @DisplayName("콘텐츠 타입 코드")
    void code() {
        assertThat(ContentType.WEBTOON.getCode()).isEqualTo("WT");
        assertThat(ContentType.WEBNOVEL.getCode()).isEqualTo("WN");
    }

    @Test
    @DisplayName("콘텐츠 타입 한글명")
    void displayName() {
        assertThat(ContentType.WEBTOON.getDisplayName()).isEqualTo("웹툰");
        assertThat(ContentType.WEBNOVEL.getDisplayName()).isEqualTo("웹소설");
    }
}
