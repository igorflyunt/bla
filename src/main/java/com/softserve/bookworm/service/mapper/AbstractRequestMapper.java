package com.softserve.bookworm.service.mapper;

import com.softserve.bookworm.model.AbstractEntity;

public abstract class AbstractRequestMapper<E extends AbstractEntity> implements RequestMapper<E> {
    protected E entity;

    protected AbstractRequestMapper(E entity) {
        this.entity = entity;
    }

    protected void setEntityIdIfExists(String stringId) {
        if (stringId == null)
            return;
        int id = Integer.parseInt(stringId);
        entity.setId(id);
    }
}
