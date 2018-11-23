package com.softserve.librarymanager.dao.table;

public class TableDefinition {
    private String table;
    private String idColumn;

    public TableDefinition(String table, String idColumn) {
        this.table = table;
        this.idColumn = idColumn;
    }

    public String getTable() {
        return table;
    }

    public String getIdColumn() {
        return idColumn;
    }
}
