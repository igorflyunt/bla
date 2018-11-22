package com.softserve.librarymanager.dao;

import java.util.List;

public class AbstractDao<E> implements Dao<E> {
    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public E findById(int id) {
        return null;
    }

    @Override
    public E saveOrUpdate(E entity) {
        return null;
    }

    @Override
    public void delete(E entity) {

    }
}
