package com.softserve.bookworm.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface Service<E> {
    Optional<E> findById(int id);

    List<E> findAll();

    E save(HttpServletRequest request);

    void delete(E entity);
}
