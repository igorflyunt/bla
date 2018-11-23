package com.softserve.librarymanager.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<E> {
    E mapToEntity(ResultSet resultSet, String columnAlias) throws SQLException;
}
