package com.softserve.bookworm.service.mapper;

import com.softserve.bookworm.model.Book;

import javax.servlet.http.HttpServletRequest;

public class BookRequestMapper extends AbstractRequestMapper<Book> implements RequestMapper<Book> {
    protected BookRequestMapper() {
        super(new Book());
    }

    @Override
    public Book mapToEntity(HttpServletRequest request) {
        setEntityIdIfExists(request.getParameter("bookId"));
        entity.setBookName(request.getParameter("bookName"));
        entity.setDescription(request.getParameter("bookDescription"));
        return entity;
    }
}
