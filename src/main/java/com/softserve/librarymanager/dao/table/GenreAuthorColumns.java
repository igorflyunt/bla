package com.softserve.librarymanager.dao.table;

public enum  GenreAuthorColumns implements Column {
    GENRE_ID("genre_id"),
    AUTHOR_ID("author_id");

    private String field;

    GenreAuthorColumns(String field) {
        this.field = field;
    }

    @Override
    public  String alias() {
        return String.format(ColumnFormat.ALIAS, Table.GENRE_AUTHOR.alias(), field);
    }

    @Override
    public String aliasedParam() {
        return String.format(ColumnFormat.PARAM, this.alias());
    }

    @Override
    public String field() {
        return this.field;
    }

    public String param() {
        return String.format(ColumnFormat.PARAM, this.field);
    }
}
