package com.softserve.librarymanager.config;

import com.google.inject.AbstractModule;
import com.softserve.librarymanager.dao.*;
import com.softserve.librarymanager.dao.impl.*;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorDao.class).to(AuthorDaoImpl.class);
        bind(BookDao.class).to(BookDaoImpl.class);
        bind(GenreDao.class).to(GenreDaoImpl.class);
        bind(UserDao.class).to(UserDaoImpl.class);
        bind(UserShelfDao.class).to(UserShelfDaoImpl.class);
    }
}
