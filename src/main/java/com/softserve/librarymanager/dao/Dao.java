package com.softserve.librarymanager.dao;

import java.util.List;

public interface Dao<E> {
    List<E> findAll();

    E findById(int id);

    E saveOrUpdate(E entity);

    void delete(E entity);
}
