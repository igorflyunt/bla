package com.softserve.librarymanager.dao.table;

public enum AuthorBookColumns implements Column {
    AUTHOR_ID("author_id"),
    BOOK_ID("book_id");

    private String field;

    AuthorBookColumns(String field) {
        this.field = field;
    }

    @Override
    public String alias() {
        return String.format(ColumnFormat.ALIAS, Tables.AUTHOR_BOOK.alias(), field);
    }

    @Override
    public String aliasedParam() {
        return String.format(ColumnFormat.PARAM, this.alias());
    }

    @Override
    public String field() {
        return this.field;
    }

    @Override
    public String param() {
        return String.format(ColumnFormat.PARAM, this.field);
    }
}
