package com.softserve.librarymanager.servlet.mapper;

import com.softserve.librarymanager.model.AbstractEntity;

import javax.servlet.http.HttpServletRequest;

public interface RequestMapper <E extends AbstractEntity> {
    E mapToEntity(HttpServletRequest request);
}
