package com.softserve.librarymanager.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<E> {
    List<E> findAll();

    Optional<E> findById(int id);

    void saveOrUpdate(E entity);

    void delete(E entity);
}
