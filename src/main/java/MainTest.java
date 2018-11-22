import com.softserve.librarymanager.dao.impl.BookDaoImpl;
import com.softserve.librarymanager.dao.impl.GenreDaoImpl;
import com.softserve.librarymanager.model.Book;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        System.out.println(new GenreDaoImpl().findGenresByBookId(3));
        System.out.println(new GenreDaoImpl().findById(3));
        Book book = new Book();
//        book.setId(3);
        book.setBookName("1984");
        book.setDescription("About totalitarism");
        book.setFirstPublished(new Date(1948, 11, 10));
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.saveOrUpdate(book);
//        bookDao.deleteById(1);
        List<Book> all = bookDao.findAll();
        System.out.println(bookDao.findById(3));
    }
}
