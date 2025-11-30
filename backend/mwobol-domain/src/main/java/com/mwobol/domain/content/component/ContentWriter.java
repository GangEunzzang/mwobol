package com.mwobol.domain.content.component;

import com.mwobol.domain.content.entity.Content;
import com.mwobol.domain.content.repository.ContentRepository;
import com.mwobol.domain.content.repository.ContentJooqRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ContentWriter {

    private final ContentRepository contentRepository;
    private final ContentJooqRepository contentJooqRepository;

    public ContentWriter(ContentRepository contentRepository, ContentJooqRepository contentJooqRepository) {
        this.contentRepository = contentRepository;
        this.contentJooqRepository = contentJooqRepository;
    }

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public void delete(Content content) {
        content.delete();
    }
}
