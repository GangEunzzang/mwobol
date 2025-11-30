package com.mwobol.domain.content.repository;

import com.mwobol.domain.content.entity.Content;
import com.mwobol.domain.content.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByPlatform(Platform platform);
}
