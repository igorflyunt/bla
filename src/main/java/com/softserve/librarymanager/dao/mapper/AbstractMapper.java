package com.softserve.librarymanager.dao.mapper;

public abstract class AbstractMapper<E> implements EntityMapper<E> {
    private static final String DEFAULT_EMPTY_ALIAS = "";

    protected String columnAlias = DEFAULT_EMPTY_ALIAS;

    protected AbstractMapper() {
    }

    protected AbstractMapper(String columnAlias) {
        this.columnAlias = columnAlias;
    }
}
