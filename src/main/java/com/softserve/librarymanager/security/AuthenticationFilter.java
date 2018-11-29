package com.softserve.librarymanager.security;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/user/bookshelf")
@Singleton
public class AuthenticationFilter implements Filter {
    @Inject
    UserSession userSession;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        final Object session = request.getSession().getAttribute("userSession");
        if (userSession == null) {
            req.getRequestDispatcher("/view/user/auth/UserSignInView.jsp").forward(req, resp);
            return;
        }
        String userId = (String) session;
        if (userSession.isSessionValid(userId, request)) {
            chain.doFilter(req, resp);
            return;
        }
        req.getRequestDispatcher("/view/user/auth/UserSignInView.jsp").forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
