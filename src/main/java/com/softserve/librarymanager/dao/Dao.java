package com.softserve.librarymanager.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<E> {
    List<E> findAll() throws SQLException;

    E findById(int id) throws SQLException;

    E save(E entity);

    void delete(E entity) throws SQLException;
}
