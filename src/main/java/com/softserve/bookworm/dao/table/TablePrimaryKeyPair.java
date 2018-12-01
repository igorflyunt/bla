package com.softserve.bookworm.dao.table;

public final class TablePrimaryKeyPair {
    public static final TablePrimaryKeyPair AUTHOR     = new TablePrimaryKeyPair("author", "id");
    public static final TablePrimaryKeyPair BOOK       = new TablePrimaryKeyPair("book", "id");
    public static final TablePrimaryKeyPair USER_SHELF = new TablePrimaryKeyPair("book_shelf", "id");
    public static final TablePrimaryKeyPair GENRE      = new TablePrimaryKeyPair("genre", "id");
    public static final TablePrimaryKeyPair USER       = new TablePrimaryKeyPair("user", "id");

    private String table;
    private String tablePrimaryKey;

    public TablePrimaryKeyPair(String table, String tablePrimaryKey) {
        this.table = table;
        this.tablePrimaryKey = tablePrimaryKey;
    }

    public String getTable() {
        return table;
    }

    public String getTablePrimaryKey() {
        return tablePrimaryKey;
    }
}
