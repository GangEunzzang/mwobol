package com.mwobol.domain.config;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.type.descriptor.jdbc.JdbcType;

import java.util.Collection;

public class NoCheckH2Dialect extends H2Dialect {

    @Override
    public String getCheckCondition(String columnName, String[] values) {
        return null;
    }

    @Override
    public String getCheckCondition(String columnName, Long[] values) {
        return null;
    }

    @Override
    public String getCheckCondition(String columnName, long min, long max) {
        return null;
    }

    @Override
    public String getCheckCondition(String columnName, Class<? extends Enum<?>> enumType) {
        return null;
    }

    @Override
    public String getCheckCondition(String columnName, Collection<?> valueSet, JdbcType jdbcType) {
        return null;
    }
}
