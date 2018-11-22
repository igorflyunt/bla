package com.softserve.librarymanager.dao.table;

public enum GenreBookColumns implements Column {
    GENRE_ID("genre_id"),
    BOOK_ID("book_id");

    private String field;

    GenreBookColumns(String field) {
        this.field = field;
    }

    @Override
    public  String alias() {
        return String.format(ColumnFormat.ALIAS, Tables.GENRE_BOOK.alias(), field);
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
