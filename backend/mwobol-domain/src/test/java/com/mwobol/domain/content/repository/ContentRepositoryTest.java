package com.mwobol.domain.content.repository;

import com.mwobol.domain.content.entity.Content;
import com.mwobol.domain.content.entity.Platform;
import com.mwobol.domain.content.fixture.ContentFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = ContentRepositoryTest.TestConfig.class)
class ContentRepositoryTest {

    @EntityScan(basePackages = "com.mwobol.domain.content.entity")
    @EnableJpaRepositories(basePackages = "com.mwobol.domain.content.repository")
    static class TestConfig {
    }

    @Autowired
    private ContentRepository contentRepository;

    @Test
    @DisplayName("Content 저장 및 조회")
    void saveAndFind() {
        // given
        Content content = ContentFixture.webtoon();

        // when
        Content saved = contentRepository.save(content);
        Optional<Content> found = contentRepository.findById(saved.getId());

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("test");
        assertThat(found.get().getPlatform()).isEqualTo(Platform.KAKAO_PAGE);
    }

    @Test
    @DisplayName("플랫폼별 Content 조회")
    void findByPlatform() {
        // given
        contentRepository.save(ContentFixture.webtoon("나혼자만레벨업", Platform.KAKAO_PAGE));
        contentRepository.save(ContentFixture.webtoon("전지적독자시점", Platform.NAVER_WEBTOON));
        contentRepository.save(ContentFixture.webtoon("김부장", Platform.KAKAO_PAGE));

        // when
        List<Content> kakaoContents = contentRepository.findByPlatform(Platform.KAKAO_PAGE);

        // then
        assertThat(kakaoContents).hasSize(2);
    }
}
