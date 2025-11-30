package com.mwobol.domain.content.entity;

import static java.util.Objects.requireNonNull;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "content")
@SQLRestriction("deleted_at IS NULL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Convert(converter = PlatformConverter.class)
    @Column(nullable = false, columnDefinition = "varchar")
    private Platform platform;

    @Convert(converter = ContentTypeConverter.class)
    @Column(nullable = false, columnDefinition = "varchar")
    private ContentType contentType;

    private LocalDateTime deletedAt;

    public static Content create(String title, Platform platform, ContentType contentType) {
        Content content = new Content();

        content.title = requireNonNull(title);
        content.platform = requireNonNull(platform);
        content.contentType = requireNonNull(contentType);

        return content;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    public boolean isWebtoon() {
        return this.contentType == ContentType.WEBTOON;
    }
}
