package com.mwobol.domain.content.fixture;

import com.mwobol.domain.content.entity.Content;
import com.mwobol.domain.content.entity.ContentType;
import com.mwobol.domain.content.entity.Platform;

public class ContentFixture {

    private static final String DEFAULT_TITLE = "test";
    private static final Platform DEFAULT_PLATFORM = Platform.KAKAO_PAGE;

    public static Content webtoon() {
        return Content.create(DEFAULT_TITLE, DEFAULT_PLATFORM, ContentType.WEBTOON);
    }

    public static Content webtoon(String title) {
        return Content.create(title, DEFAULT_PLATFORM, ContentType.WEBTOON);
    }

    public static Content webtoon(String title, Platform platform) {
        return Content.create(title, platform, ContentType.WEBTOON);
    }

    public static Content webnovel() {
        return Content.create(DEFAULT_TITLE, DEFAULT_PLATFORM, ContentType.WEBNOVEL);
    }

    public static Content webnovel(String title) {
        return Content.create(title, DEFAULT_PLATFORM, ContentType.WEBNOVEL);
    }

    public static Content webnovel(String title, Platform platform) {
        return Content.create(title, platform, ContentType.WEBNOVEL);
    }
}
