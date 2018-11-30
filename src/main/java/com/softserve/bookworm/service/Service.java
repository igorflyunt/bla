package com.softserve.bookworm.service;

import java.util.List;
import java.util.Optional;

public interface Service<E> {
    Optional<E> findById(int id);

    List<E> findAll();

    void save(E entity);

    void delete(E entity);
}
