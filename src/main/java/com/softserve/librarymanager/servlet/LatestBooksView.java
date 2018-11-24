package com.softserve.librarymanager.servlet;

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
public class LatestBooksView extends HttpServlet {
    private BookService bookService = new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> tenLatestBooks = bookService.findTenLatestBooks();
        request.setAttribute("books", tenLatestBooks);
        request.setAttribute("indexPageName", "Latest Books");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
