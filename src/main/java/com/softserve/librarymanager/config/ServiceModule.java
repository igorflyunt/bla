package com.softserve.librarymanager.config;

import com.google.inject.AbstractModule;
import com.softserve.librarymanager.service.*;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorService.class).to(AuthorServiceImpl.class);
        bind(BookService.class).to(BookServiceImpl.class);
        bind(BookShelfService.class).to(BookShelfServiceImpl.class);
    }
}
