package com.softserve.bookworm.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.model.AbstractEntity;
import com.softserve.bookworm.model.Book;
import com.softserve.bookworm.service.AuthorService;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/book")
@Singleton
public class EditBookServlet extends HttpServlet {
    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = getIdParameterIfExists(request.getParameter("authorId"));
        Book book = bookService.save(request);
        if (authorId != AbstractEntity.NO_ELEMENT)
            bookService.mapBookToAuthor(book.getId(), authorId);
        response.sendRedirect("/admin/books");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        List<Book> books = bookService.findBooksByAuthorId(authorId);
        request.setAttribute("books", books);
        request.getRequestDispatcher(Jsp.BOOK_EDITOR_VIEW).forward(request, response);
    }

    private int getIdParameterIfExists(String stringParam) {
        if (stringParam == null || stringParam.isEmpty())
            return AbstractEntity.NO_ELEMENT;
        return Integer.parseInt(stringParam);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        bookService.findById(bookId).ifPresent(bookService::delete);
    }
}
