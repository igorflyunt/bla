package com.softserve.librarymanager.dao.table;

public final class TablePrimaryKeyPairs {
    public static final TablePrimaryKeyPair AUTHOR = new TablePrimaryKeyPair("author", "id");
    public static final TablePrimaryKeyPair BOOK = new TablePrimaryKeyPair("book", "id");
    public static final TablePrimaryKeyPair USER_SHELF = new TablePrimaryKeyPair("book_shelf", "id");
    public static final TablePrimaryKeyPair GENRE = new TablePrimaryKeyPair("genre", "id");
    public static final TablePrimaryKeyPair USER = new TablePrimaryKeyPair("user", "id");

    private TablePrimaryKeyPairs() { }
}
