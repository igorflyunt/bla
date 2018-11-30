package com.softserve.bookworm.servlet.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
@Singleton
public class BookDetailsServlet extends HttpServlet {
    @Inject
    private BookService bookService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        bookService.findById(bookid).ifPresent(b-> request.setAttribute("book", b));
        request.getRequestDispatcher(Jsp.BOOK_DETAILS_VIEW).forward(request, response);
    }
}
