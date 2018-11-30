package com.softserve.bookworm.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.softserve.bookworm.security.UserShelfFilter;
import com.softserve.bookworm.servlet.admin.AdminHomeServlet;
import com.softserve.bookworm.servlet.admin.BooksEditorServlet;
import com.softserve.bookworm.servlet.admin.EditAuthorServlet;
import com.softserve.bookworm.servlet.admin.EditBookServlet;
import com.softserve.bookworm.servlet.user.*;
import com.softserve.bookworm.servlet.user.auth.UserSignInServlet;
import com.softserve.bookworm.servlet.user.auth.UserSignUpServlet;

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
                serve("/admin/author").with(EditAuthorServlet.class);
                serve("/admin/book").with(EditBookServlet.class);
                serve("/admin").with(AdminHomeServlet.class);
                serve("/admin/books").with(BooksEditorServlet.class);
                serve("/user/bookshelf").with(UserBookshelfServlet.class);
                serve("/user/auth/signup").with(UserSignUpServlet.class);
                serve("/user/auth/signin").with(UserSignInServlet.class);
                filter("/user/bookshelf").through(UserShelfFilter.class);
            }
        }, new ServiceModule(), new DaoModule());
    }
}
