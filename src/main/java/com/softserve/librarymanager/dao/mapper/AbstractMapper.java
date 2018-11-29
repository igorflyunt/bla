package com.softserve.librarymanager.dao.mapper;

public abstract class AbstractMapper<E> implements EntityMapper<E> {
    private static final String DEFAULT_EMPTY_ALIAS = "";

    protected String columnAlias = DEFAULT_EMPTY_ALIAS;

    public AbstractMapper() {
    }

    public AbstractMapper(String columnAlias) {
        this.columnAlias = columnAlias;
    }
}
