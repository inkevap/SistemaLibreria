package interfaces;

import model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {

    public void addBook(Book book);

    public Optional<Book> findBookByIsbn(String isbn);

    public List<Book> findBookByText(String text);

    public void removeBook(String isbn);

    public void updateBook(Book book);
}
