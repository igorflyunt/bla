package com.softserve.librarymanager.servlet.user;

import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookOverview extends HttpServlet {
    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,
            IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<Book> books = bookService.findAllBooks();
        request.setAttribute("books", books);
        request.setAttribute("indexPageName", "All books");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
