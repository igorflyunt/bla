package com.softserve.bookworm.service;

import com.softserve.bookworm.dao.Dao;
import com.softserve.bookworm.model.AbstractEntity;
import com.softserve.bookworm.service.mapper.RequestMapper;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractService<E extends AbstractEntity, D extends Dao<E>> implements Service<E> {
    private D                dao;
    private RequestMapper<E> requestMapper;

    public AbstractService(D dao, RequestMapper<E> requestMapper) {
        this.dao = dao;
        this.requestMapper = requestMapper;
    }

    public D getDao() {
        return dao;
    }

    @Override
    public void save(HttpServletRequest request) {
        E entity = requestMapper.mapToEntity(request);
        this.dao.saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        this.dao.delete(entity);
    }
}
