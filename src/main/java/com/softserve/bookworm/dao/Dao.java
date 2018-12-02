package com.softserve.bookworm.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<E> {
    List<E> findAll();

    Optional<E> findById(int id);

    E saveOrUpdate(E entity);

    void delete(E entity);
}
