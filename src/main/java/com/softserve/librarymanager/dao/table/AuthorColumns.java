package com.softserve.librarymanager.dao.table;

public enum AuthorColumns implements Column {
    ALL("*"),
    ID("ID"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    BIRTH_DATE("birth_date");

    private String field;

    AuthorColumns(String field) {
        this.field = field;
    }

    @Override
    public String alias() {
        return String.format(ColumnFormat.ALIAS, Table.AUTHOR.alias(), field);
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