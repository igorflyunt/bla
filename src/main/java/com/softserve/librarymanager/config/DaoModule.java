package com.softserve.librarymanager.config;

import com.google.inject.AbstractModule;
import com.softserve.librarymanager.dao.AuthorDao;
import com.softserve.librarymanager.dao.BookDao;
import com.softserve.librarymanager.dao.GenreDao;
import com.softserve.librarymanager.dao.impl.AuthorDaoImpl;
import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorDao.class).to(AuthorDaoImpl.class);
        bind(BookDao.class).to(BookDaoImpl.class);
        bind(GenreDao.class).to(GenreDaoImpl.class);
    }
}
