package com.softserve.librarymanager.servlet.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.model.BookShelf;
import com.softserve.librarymanager.model.User;
import com.softserve.librarymanager.security.UserSession;
import com.softserve.librarymanager.service.BookService;
import com.softserve.librarymanager.service.BookShelfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user/bookshelf")
@Singleton
public class UserBookshelfServlet extends HttpServlet {
    private static Map<String, String> viewShelfNameMap = new HashMap<>();

    static {
        viewShelfNameMap.put("currently-reading", "Currently reading");
        viewShelfNameMap.put("to-read", "Want to Read");
        viewShelfNameMap.put("read", "Read");
    }

    @Inject
    private UserSession userSession;

    @Inject
    private BookService bookService;

    @Inject
    private BookShelfService bookShelfService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        User authorizedUser = userSession.getAuthorizedUser(request);
        bookShelfService.saveBookToShelf(authorizedUser.getId(), request);
        response.sendRedirect("/user/bookshelf?shelf=all");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = userSession.getAuthorizedUser(request);
        String paramShelfName = request.getParameter("shelf");
        List<BookShelf> shelf = getAllShelvesOrOne(user, paramShelfName);
        request.setAttribute("shelfName", viewShelfNameMap.get(paramShelfName));
        setupButtonShelfName(request, shelf);
        request.setAttribute("shelfList", shelf);
        request.getRequestDispatcher("/view/user/Bookshelves.jsp").forward(request, response);
    }

    private void setupButtonShelfName(HttpServletRequest request, List<BookShelf> shelfList) {
        List<String> selectButtonShelfNames = new ArrayList<>();
        for (BookShelf bookShelf : shelfList) {
             selectButtonShelfNames.add(viewShelfNameMap.get(bookShelf.getBookShelfName()));
        }
        request.setAttribute("selectButtonShelfName", selectButtonShelfNames);
    }

    private List<BookShelf> getAllShelvesOrOne(User user, String shelfName) {
        List<BookShelf> shelf;
        if (shelfName.equals("all")) {
            shelf = bookShelfService.findAllShelvesByUserId(user.getId());
        } else {
            shelf = bookShelfService.findShelfByNameAndUserId(shelfName, user.getId());
        }
        return shelf;
    }
}
