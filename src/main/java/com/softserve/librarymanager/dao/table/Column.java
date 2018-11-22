package com.softserve.librarymanager.dao.table;

public interface Column {
    String alias();

    String param();

    String aliasedParam();

    String field();
}
