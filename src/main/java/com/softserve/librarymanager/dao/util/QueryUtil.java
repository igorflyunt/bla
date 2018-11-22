package com.softserve.librarymanager.dao.util;

import com.softserve.librarymanager.model.AbstractEntity;

public final class QueryUtil {
    private QueryUtil() {}

    public static boolean entityExists(AbstractEntity entity) {
        return entity.getId() != AbstractEntity.NO_ELEMENT;
    }
}
