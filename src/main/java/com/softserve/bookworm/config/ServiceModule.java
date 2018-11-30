package com.softserve.bookworm.config;

import com.google.inject.AbstractModule;
import com.softserve.bookworm.service.AuthorService;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.service.UserShelfService;
import com.softserve.bookworm.service.impl.AuthorServiceImpl;
import com.softserve.bookworm.service.impl.BookServiceImpl;
import com.softserve.bookworm.service.impl.UserShelfServiceImpl;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorService.class).to(AuthorServiceImpl.class);
        bind(BookService.class).to(BookServiceImpl.class);
        bind(UserShelfService.class).to(UserShelfServiceImpl.class);
    }
}
