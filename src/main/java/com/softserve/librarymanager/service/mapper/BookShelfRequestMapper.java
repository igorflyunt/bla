package com.softserve.librarymanager.service.mapper;

import com.softserve.librarymanager.model.BookShelf;

import javax.servlet.http.HttpServletRequest;

public class BookShelfRequestMapper implements RequestMapper<BookShelf> {

    @Override
    public BookShelf mapToEntity(HttpServletRequest request) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.setBookShelfName(request.getParameter("shelf"));
        return bookShelf;
    }
}
