package com.softserve.librarymanager.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.softserve.librarymanager.servlet.admin.AdminBooks;
import com.softserve.librarymanager.servlet.admin.AdminHome;
import com.softserve.librarymanager.servlet.admin.EditAuthor;
import com.softserve.librarymanager.servlet.admin.EditBook;
import com.softserve.librarymanager.servlet.user.*;

public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/").with(LatestBooksServlet.class);
                serve("/book").with(BookDetailsServlet.class);
                serve("/books").with(AllBooksServlet.class);
                serve("/author").with(AuthorDetailsServlet.class);
                serve("/admin/author").with(EditAuthor.class);
                serve("/admin/book").with(EditBook.class);
                serve("/admin").with(AdminHome.class);
                serve("/admin/books").with(AdminBooks.class);
                serve("/user/bookshelf").with(UserBookshelfServlet.class);
                serve("/user/auth/signup").with(UserSignUpServlet.class);
                serve("/user/auth/signin").with(UserSignInServlet.class);
            }
        }, new ServiceModule(), new DaoModule());
    }
}
