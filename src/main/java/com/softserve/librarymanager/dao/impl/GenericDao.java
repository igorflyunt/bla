package com.softserve.librarymanager.dao.impl;

import com.softserve.librarymanager.dao.Dao;
import com.softserve.librarymanager.dao.mapper.EntityMapper;
import com.softserve.librarymanager.dao.table.TableDefinition;
import com.softserve.librarymanager.db.DataSource;
import com.softserve.librarymanager.model.AbstractEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericDao<E extends AbstractEntity> implements Dao<E> {
    private Connection connection = DataSource.getDbConnection();
    private EntityMapper<E> entityMapper;
    private TableDefinition tableDefinition;

    protected GenericDao(TableDefinition tableDefinition, EntityMapper<E> entityMapper) {
        this.tableDefinition = tableDefinition;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<E> findAll() {
        List<E> entities = new ArrayList<>();
        String query = String.format("select * from %s", tableDefinition.getTable());
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                entities.add(entityMapper.mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(query);
        return entities;
    }

    @Override
    public Optional<E> findById(int id) {
        String query = String.format("select * from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getIdColumn());
        E entity = null;
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                  entity = entityMapper.mapToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(query);
        return Optional.ofNullable(entity);
    }

    protected void save(E entity, String query, Object... paramArgs) {
        try {
            PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < paramArgs.length; i++) {
                Object param = paramArgs[i];
                st.setObject(i + 1, param);
            }
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next())
                entity.setId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(query);
    }

    protected boolean doesEntityExists(int id) {
        return findById(id).isPresent();
    }

    protected List<E> query(String query, EntityMapper<E> entityMapper, Object... paramArgs) {
        List<E> entities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(query);
            for (int i = 0; i < paramArgs.length; i++) {
                Object paramArg = paramArgs[i];
                st.setObject(i + 1, paramArg);
            }
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                entities.add(entityMapper.mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    @Override
    public void delete(E entity) {
        String query = String.format("delete from %s where %s = ?", tableDefinition.getTable(),
                tableDefinition.getIdColumn());
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, entity.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(query);
    }
}

