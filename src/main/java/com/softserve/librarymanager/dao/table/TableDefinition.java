package com.softserve.librarymanager.dao.table;

public class TableDefinition {
    private String table;
    private String tablePrimaryKey;

    public TableDefinition(String table, String tablePrimaryKey) {
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
