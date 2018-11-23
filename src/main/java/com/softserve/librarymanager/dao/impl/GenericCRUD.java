package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.db.DataSource;
import com.softserve.librarymanager.model.AbstractEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericCRUD<E extends AbstractEntity> implements Dao<E> {
    private static final String NO_ALIAS = "";

    private Connection connection = DataSource.getDbConnection();

    private EntityMapper<E> entityMapper;
    private TableDefinition tableDefinition;

    protected GenericCRUD(TableDefinition tableDefinition, EntityMapper<E> entityMapper) {
        this.tableDefinition = tableDefinition;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<E> findAll() throws SQLException {
        String query = String.format("select * from %s", tableDefinition.getTable());
        ResultSet resultSet = connection.prepareStatement(query).executeQuery();
        List<E> entities = new ArrayList<>();
        while (resultSet.next()) {
            entities.add(entityMapper.mapToEntity(resultSet, NO_ALIAS));
        }
        return entities;
    }

    @Override
    public E findById(int id) throws SQLException {
        String query = String.format("select * from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getIdColumn());
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, id);
        ResultSet resultSet = st.executeQuery();
        E entity = null;
        if (resultSet.next()) {
              entity = entityMapper.mapToEntity(resultSet, NO_ALIAS);
        }
        return entity;
    }

    protected E save(E entity, String query, Object... paramArgs) throws SQLException {
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < paramArgs.length; i++) {
            Object param = paramArgs[i];
            st.setObject(i + 1, param);
        }
        st.executeUpdate();
        ResultSet generatedKeys = st.getGeneratedKeys();
        if (generatedKeys.next())
            entity.setId(generatedKeys.getInt(1));
        return entity;
    }

    @Override
    public void delete(E entity) throws SQLException {
        String query = String.format("delete from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getIdColumn());
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, entity.getId());
        st.executeUpdate();
    }
}

