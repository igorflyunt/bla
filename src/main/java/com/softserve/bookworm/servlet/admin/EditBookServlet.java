package com.softserve.bookworm.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
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
        addBookToAuthorOrUpdate(request);
        response.sendRedirect("/admin/books");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        List<Book> books = bookService.findBooksByAuthorId(authorId);
        request.setAttribute("books", books);
        request.getRequestDispatcher(Jsp.BOOK_EDITOR_VIEW).forward(request, response);
    }

    private void addBookToAuthorOrUpdate(HttpServletRequest request) {
        String authorId = request.getParameter("authorId");
        Book book = bookService.save(request);
        if (bookEditingRequested(authorId))
            bookService.addBookToAuthor(book.getId(), Integer.parseInt(authorId));
    }

    private boolean bookEditingRequested(String authorId) {
        return authorId != null;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        bookService.findById(bookId).ifPresent(bookService::delete);
    }
}
