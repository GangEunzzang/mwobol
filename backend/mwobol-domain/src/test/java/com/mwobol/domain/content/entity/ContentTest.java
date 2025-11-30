package com.mwobol.domain.content.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContentTest {

    private static final String TITLE = "나 혼자만 레벨업";
    private static final Platform PLATFORM = Platform.KAKAO_PAGE;
    private static final ContentType WEBTOON = ContentType.WEBTOON;
    private static final ContentType WEBNOVEL = ContentType.WEBNOVEL;

    @Test
    @DisplayName("Content 생성 - 팩토리 메서드")
    void createContent() {
        // when
        Content content = Content.create(TITLE, PLATFORM, WEBTOON);

        // then
        assertThat(content.getTitle()).isEqualTo(TITLE);
        assertThat(content.getPlatform()).isEqualTo(PLATFORM);
        assertThat(content.getContentType()).isEqualTo(WEBTOON);
        assertThat(content.getId()).isNull();
    }

    @Test
    @DisplayName("Content 생성 실패 - title이 null")
    void createContent_nullTitle() {
        assertThatThrownBy(() -> Content.create(null, PLATFORM, WEBTOON))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Content 생성 실패 - platform이 null")
    void createContent_nullPlatform() {
        assertThatThrownBy(() -> Content.create(TITLE, null, WEBTOON))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Content 생성 실패 - contentType이 null")
    void createContent_nullContentType() {
        assertThatThrownBy(() -> Content.create(TITLE, PLATFORM, null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("웹툰인지 확인")
    void isWebtoon() {
        Content webtoon = createWebtoon();
        Content webnovel = createWebnovel();

        assertThat(webtoon.isWebtoon()).isTrue();
        assertThat(webnovel.isWebtoon()).isFalse();
    }

    private Content createWebtoon() {
        return Content.create(TITLE, PLATFORM, WEBTOON);
    }

    private Content createWebnovel() {
        return Content.create("전지적 독자 시점", Platform.NAVER_SERIES, WEBNOVEL);
    }
}
