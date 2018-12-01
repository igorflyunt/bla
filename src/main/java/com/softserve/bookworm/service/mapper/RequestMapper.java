package com.softserve.bookworm.service.mapper;

import com.softserve.bookworm.model.AbstractEntity;

import javax.servlet.http.HttpServletRequest;

public interface RequestMapper <E extends AbstractEntity> {
    E mapToEntity(HttpServletRequest request);
}
