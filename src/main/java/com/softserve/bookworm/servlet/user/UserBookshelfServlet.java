package com.softserve.bookworm.servlet.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.bookworm.model.BookShelf;
import com.softserve.bookworm.model.User;
import com.softserve.bookworm.security.UserSession;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.service.UserShelfService;
import com.softserve.bookworm.servlet.Jsp;

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
    private UserShelfService userShelfService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User authorizedUser = userSession.getAuthorizedUser(request);
        userShelfService.saveBookToShelf(authorizedUser.getId(), request);
        response.sendRedirect("/user/bookshelf?shelf=all");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = userSession.getAuthorizedUser(request);
        String paramShelfName = request.getParameter("shelf");
        List<BookShelf> shelf = getAllShelvesOrOne(user, paramShelfName);
        request.setAttribute("shelfName", viewShelfNameMap.get(paramShelfName));
        setupSelectShelfButtonName(request, shelf);
        request.setAttribute("shelfList", shelf);
        request.getRequestDispatcher(Jsp.USER_SHELF_VIEW).forward(request, response);
    }

    private void setupSelectShelfButtonName(HttpServletRequest request, List<BookShelf> shelfList) {
        List<String> selectButtonShelfNames = new ArrayList<>();
        for (BookShelf bookShelf : shelfList) {
             selectButtonShelfNames.add(viewShelfNameMap.get(bookShelf.getBookShelfName()));
        }
        request.setAttribute("selectButtonShelfName", selectButtonShelfNames);
    }

    private List<BookShelf> getAllShelvesOrOne(User user, String shelfName) {
        List<BookShelf> shelf;
        if (shelfName.equals("all")) {
            shelf = userShelfService.findAllShelvesByUserId(user.getId());
        } else {
            shelf = userShelfService.findShelfByNameAndUserId(shelfName, user.getId());
        }
        return shelf;
    }
}
