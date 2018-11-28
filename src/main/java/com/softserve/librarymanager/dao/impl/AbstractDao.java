package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.db.DataSource;
import com.softserve.librarymanager.db.JDBCQuery;
import com.softserve.librarymanager.model.AbstractEntity;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<E extends AbstractEntity> implements Dao<E> {
    private Connection connection = DataSource.getDbConnection();
    private EntityMapper<E> entityMapper;
    private TableDefinition tableDefinition;

    protected AbstractDao(TableDefinition tableDefinition, EntityMapper<E> entityMapper) {
        this.tableDefinition = tableDefinition;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<E> findAll() {
        String query = String.format("select * from %s", tableDefinition.getTable());
        List<E> entities = JDBCQuery.selectMany(query, entityMapper);
        System.out.println(query);
        return entities;
    }

    @Override
    public Optional<E> findById(int id) {
        String query = String.format("select * from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getTablePrimaryKey());
        E entity = JDBCQuery.selectOne(query, entityMapper, id);
        System.out.println(query);
        return Optional.ofNullable(entity);
    }

    protected boolean entityExists(int entityId) {
        return findById(entityId).isPresent();
    }

    @Override
    public void delete(E entity) {
        String query = String.format("delete from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getTablePrimaryKey());
        JDBCQuery.update(entity, query, entity.getId());
        System.out.println(query);
    }
}

