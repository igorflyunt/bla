package com.softserve.librarymanager.security;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.softserve.librarymanager.dao.UserDao;
import com.softserve.librarymanager.dao.impl.UserDaoImpl;
import com.softserve.librarymanager.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class UserSession {
    @Inject
    private static UserDao userDao = new UserDaoImpl();

    private static Map<String, String> userSession = new HashMap<>();

    public UserSession() {
    }

    public void addToSession(String userId, HttpServletRequest request) {
        userSession.put(userId, request.getSession().getId());
        request.getSession().setAttribute("userSession", userId);
    }

    public void clearSession(String userId) {
        userSession.remove(userId);
    }

    public boolean isSessionValid(String userId, HttpServletRequest request) {
        if (userSession.containsKey(userId))
            return userSession.get(userId).equals(request.getSession().getId());
        return false;
    }

    public User getAuthorizedUser(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("userSession");
        System.out.println(user);
        return userDao.findUserByUsername(user);
    }
}
