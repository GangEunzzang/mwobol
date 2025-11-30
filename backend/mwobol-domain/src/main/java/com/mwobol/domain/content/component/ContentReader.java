package com.mwobol.domain.content.component;

import com.mwobol.domain.content.entity.Content;
import com.mwobol.domain.content.entity.Platform;
import com.mwobol.domain.content.repository.ContentRepository;
import com.mwobol.domain.content.repository.ContentJooqRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional(readOnly = true)
public class ContentReader {

    private final ContentRepository contentRepository;
    private final ContentJooqRepository contentJooqRepository;

    public ContentReader(ContentRepository contentRepository, ContentJooqRepository contentJooqRepository) {
        this.contentRepository = contentRepository;
        this.contentJooqRepository = contentJooqRepository;
    }

    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }

    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    public List<Content> findByPlatform(Platform platform) {
        return contentRepository.findByPlatform(platform);
    }
}
