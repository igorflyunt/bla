package com.softserve.librarymanager.dao.table.util;

import com.softserve.librarymanager.dao.table.ColumnFormat;

public final class ColumnUtil {

    private ColumnUtil() { }

    public static String createColumnWithAlias(String column, String alias) {
        if (alias.isEmpty())
            return column;
        return String.format(ColumnFormat.ALIAS, column, alias);
    }
}
