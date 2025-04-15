package interfaces;

import model.Book;

import java.util.Optional;

public interface IBookRepository {

    public void addBook(Book book);

    public Optional<Book> findBookByIsbn(String isbn);

    public Optional<Book> findBookByText(String text);

    public void removeBook(String isbn);

    public void updateBook(Book book);
}
