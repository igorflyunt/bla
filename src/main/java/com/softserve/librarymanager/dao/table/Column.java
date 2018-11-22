package com.softserve.librarymanager.dao.table;

interface Column {
    String alias();

    String param();

    String aliasedParam();

    String field();
}
