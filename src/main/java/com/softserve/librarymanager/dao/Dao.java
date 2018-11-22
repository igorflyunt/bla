package com.softserve.librarymanager.dao;

import com.softserve.librarymanager.dao.table.Column;
import com.softserve.librarymanager.dao.table.Table;
import com.softserve.librarymanager.dao.table.TableDefinition;

import java.util.List;

public interface Dao<E, T extends Enum<Table>, C extends Enum<C> & Column> {
    List<E> findAll(TableDefinition<T, C> tableDefinition);

    E findById(TableDefinition<T, C> tableDefinition, int id);

    E saveOrUpdate(TableDefinition<T, C> tableDefinition, E entity);

    void delete(TableDefinition<T, C> tableDefinition, E entity);
}
