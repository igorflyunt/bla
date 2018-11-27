package com.softserve.librarymanager.servlet.admin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.AbstractEntity;
import com.softserve.librarymanager.model.Book;
import com.softserve.librarymanager.service.AuthorService;
import com.softserve.librarymanager.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/book")
@Singleton
public class EditBook extends HttpServlet {
    @Inject
    private AuthorService authorService;

    @Inject
    private BookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = getIdParemeterIfExists(request.getParameter("authorId"));
        String bookName = request.getParameter("bookName");
        String bookDescription = request.getParameter("bookDescription");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Book book = new Book();
        setEntityIdIfExists(request.getParameter("bookId"), book);
        book.setBookName(bookName);
        book.setDescription(bookDescription);
        try {
            Date firstPublished = format.parse(request.getParameter("publicationYear"));
            book.setFirstPublished(firstPublished);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookService.save(book);
        bookService.mapBookToAuthor(book.getId(), authorId);
        response.sendRedirect("/admin/author");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        List<Book> books = bookService.findBooksByAuthorId(authorId);
        request.setAttribute("books", books);
        request.getRequestDispatcher("/view/admin/BookEditor.jsp").forward(request, response);
    }

    private int getIdParemeterIfExists(String stringParam) {
        if (stringParam == null || stringParam.isEmpty())
            return AbstractEntity.NO_ELEMENT;
        return Integer.parseInt(stringParam);
    }

    private void setEntityIdIfExists(String stringId, AbstractEntity entity) {
        if (stringId == null || stringId.isEmpty())
            return;
        int id = Integer.parseInt(stringId);
        entity.setId(id);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
