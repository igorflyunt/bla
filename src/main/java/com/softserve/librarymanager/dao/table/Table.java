package com.softserve.librarymanager.dao.table;

public enum Table {
    GENRE("genre", "g"),
    AUTHOR("author", "a"),
    BOOK("book", "b"),
    GENRE_BOOK("genre_book", "gb"),
    GENRE_AUTHOR("genre_author", "ga"),
    AUTHOR_BOOK("author_book", "ab"),
    NO_TABLE("", "");

    private String tableName;
    private String tableAlias;

    Table(String tableName, String tableAlias) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
    }

    public String table() {
        return this.tableName;
    }

    public String aliasedTable() {
        return String.format("%s %s", tableName, tableAlias);
    }

    public String alias() {
        return this.tableAlias;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
