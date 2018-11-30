package com.softserve.librarymanager.config;

import com.google.inject.AbstractModule;
import com.softserve.librarymanager.service.AuthorService;
import com.softserve.librarymanager.service.BookService;
import com.softserve.librarymanager.service.UserShelfService;
import com.softserve.librarymanager.service.impl.AuthorServiceImpl;
import com.softserve.librarymanager.service.impl.BookServiceImpl;
import com.softserve.librarymanager.service.impl.UserShelfServiceImpl;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorService.class).to(AuthorServiceImpl.class);
        bind(BookService.class).to(BookServiceImpl.class);
        bind(UserShelfService.class).to(UserShelfServiceImpl.class);
    }
}
