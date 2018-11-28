package com.softserve.librarymanager.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
@Singleton
public class LatestBooksServlet extends HttpServlet {
    @Inject
    private BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> tenLatestBooks = bookService.findTenLatestBooks();
        request.setAttribute("books", tenLatestBooks);
        request.setAttribute("indexPageName", "Latest Books");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
