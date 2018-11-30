package com.softserve.bookworm.servlet.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.model.Book;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.servlet.Jsp;

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
        request.getRequestDispatcher(Jsp.INDEX_VIEW).forward(request, response);
    }
}
