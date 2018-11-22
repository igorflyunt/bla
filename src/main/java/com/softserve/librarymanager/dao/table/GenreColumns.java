package com.softserve.librarymanager.dao.table;

public enum GenreColumns implements Column {
    ALL("*"),
    ID("id"),
    NAME("name");

    private String field;

    GenreColumns(String field) {
        this.field = field;
    }

    @Override
    public String alias() {
        return String.format(ColumnFormat.ALIAS, Tables.GENRE.alias(), field);
    }

    @Override
    public String aliasedParam() {
        return String.format(ColumnFormat.PARAM, this.alias());
    }

    @Override
    public String param() {
        return String.format(ColumnFormat.PARAM, this.field);
    }

    @Override
    public String field() {
        return this.field;
    }
}
