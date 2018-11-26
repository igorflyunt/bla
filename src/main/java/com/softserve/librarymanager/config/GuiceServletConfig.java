package com.softserve.librarymanager.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.softserve.librarymanager.servlet.admin.EditAuthor;
import com.softserve.librarymanager.servlet.admin.EditBook;
import com.softserve.librarymanager.servlet.user.AuthorView;
import com.softserve.librarymanager.servlet.user.BookOverview;
import com.softserve.librarymanager.servlet.user.BookView;
import com.softserve.librarymanager.servlet.user.LatestBooksView;

public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/").with(LatestBooksView.class);
                serve("/book").with(BookView.class);
                serve("/books").with(BookOverview.class);
                serve("/author").with(AuthorView.class);
                serve("/admin/author").with(EditAuthor.class);
                serve("/admin/book").with(EditBook.class);
            }
        }, new ServiceModule(), new DaoModule());
    }
}
