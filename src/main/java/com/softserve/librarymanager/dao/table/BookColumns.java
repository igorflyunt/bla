package com.softserve.librarymanager.dao.table;

public enum BookColumns implements Column {
    ALL("*"),
    ID("id"),
    NAME("name"),
    DESCRIPTION("description"),
    FIRST_PUBLISHED("first_published");

    private String field;

    BookColumns(String field) {
        this.field = field;
    }

    @Override
    public String alias() {
        return String.format(ColumnFormat.ALIAS, Table.BOOK.alias(), field);
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
