package com.softserve.bookworm.service.impl;

import com.google.inject.Inject;
import com.softserve.bookworm.dao.UserDao;
import com.softserve.bookworm.dao.UserShelfDao;
import com.softserve.bookworm.model.BookShelf;
import com.softserve.bookworm.service.AbstractService;
import com.softserve.bookworm.service.BookService;
import com.softserve.bookworm.service.UserShelfService;
import com.softserve.bookworm.service.mapper.BookShelfRequestMapper;
import com.softserve.bookworm.service.mapper.RequestMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserShelfServiceImpl extends AbstractService<BookShelf, UserShelfDao> implements UserShelfService {
    @Inject
    private BookService bookService;

    @Inject
    private UserDao userDao;

    private RequestMapper<BookShelf> bookShelfRequestMapper = new BookShelfRequestMapper();

    @Inject
    public UserShelfServiceImpl(UserShelfDao dao) {
        super(dao);
    }

    @Override
    public void saveBookToShelf(int userId, HttpServletRequest bookShelfRequest) {
        BookShelf bookShelf = bookShelfRequestMapper.mapToEntity(bookShelfRequest);
        userDao.findById(userId).ifPresent(bookShelf::setUser);
        int bookId = Integer.parseInt(bookShelfRequest.getParameter("bookId"));
        bookService.findById(bookId).ifPresent(bookShelf::setBook);
        getDao().saveOrUpdate(bookShelf);
    }

    @Override
    public List<BookShelf> findShelfByNameAndUserId(String shelfName, int userId) {
        List<BookShelf> shelf = getDao().findShelfByNameAndUserId(shelfName, userId);
        initBookShelfEagerly(shelf);
        return shelf;
    }

    private void initBookShelfEagerly(List<BookShelf> shelf) {
        for (BookShelf bookShelf : shelf) {
            bookService.findById(bookShelf.getBook().getId()).ifPresent(bookShelf::setBook);
        }
    }

    @Override
    public List<BookShelf> findAllShelvesByUserId(int userId) {
        List<BookShelf> shelves = getDao().findAllShelvesByUserId(userId);
        initBookShelfEagerly(shelves);

        return shelves;
    }

    @Override
    public Optional<BookShelf> findById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public List<BookShelf> findAll() {
        throw new NotImplementedException();
    }
}
