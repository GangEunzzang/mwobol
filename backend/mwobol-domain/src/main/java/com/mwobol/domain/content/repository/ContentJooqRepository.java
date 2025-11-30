package com.mwobol.domain.content.repository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ContentJooqRepository {

    private final DSLContext dsl;

    public ContentJooqRepository(DSLContext dsl) {
        this.dsl = dsl;
    }
}
