package repository;

import interfaces.IBookRepository;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryBookRepository implements IBookRepository {
    private final List<Book> books;

    public MemoryBookRepository() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream().filter(
                        actualBook ->
                                actualBook.getIsbnCode()
                                        .equals(isbn))
                .findFirst();
    }

    public Optional<Book> findBookByText(String text) {
        return books.stream().filter(
                        actualBook ->
                                actualBook.getIsbnCode().equals(text) ||
                                        actualBook.getBookAuthor().equals(text) ||
                                        actualBook.getBookEditorial().equals(text) ||
                                        actualBook.getBookTitle().equals(text)
                )
                .findFirst();
    }

    public void removeBook(String isbn) {
        findBookByIsbn(isbn).ifPresent(books::remove);
    }

    public void updateBook(Book book) {
    }

}
