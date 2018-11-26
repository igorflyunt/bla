package com.softserve.librarymanager.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.service.AuthorService;
import com.softserve.librarymanager.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/book")
@Singleton
public class EditBook extends HttpServlet {
    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        String bookName = request.getParameter("bookName");
        String bookDescription = request.getParameter("bookDescription");
        Book book = new Book();
        book.setBookName(bookName);
        book.setDescription(bookDescription);
        bookService.save(book);
        bookService.mapBookToAuthor(book.getId(), authorId);
        response.sendRedirect("/admin/author");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/admin/BookEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
