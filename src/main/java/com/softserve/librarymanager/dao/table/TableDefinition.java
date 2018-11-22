package com.softserve.librarymanager.dao.table;

public class TableDefinition <T extends Enum<Table>, C extends Enum<C> & Column> {
    private T table;
    private Enum<C>[] columns;

    public TableDefinition(T table, Enum<C>[] columns) {
        this.table = table;
        this.columns = columns;
    }

    public T getTable() {
        return table;
    }

    public Enum<C>[] getColumns() {
        return columns;
    }
}
