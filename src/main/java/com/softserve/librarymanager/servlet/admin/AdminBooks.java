package com.softserve.librarymanager.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.service.BookService;
import com.softserve.librarymanager.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/books")
@Singleton
public class AdminBooks extends HttpServlet {
    @Inject
    private BookService bookService;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher(Jsp.BOOKS_EDITOR_VIEW).forward(request, response);
    }
}
