package com.softserve.librarymanager.dao.table;

public class TablePrimaryKeyPair {
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
