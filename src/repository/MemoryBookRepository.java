package repository;

import interfaces.IBookRepository;
import model.Book;
import util.BookUpdater;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Book> findBookByText(String text) {
        return books.stream().filter(
                        actualBook ->
                                actualBook.getIsbnCode().toLowerCase().contains(text.toLowerCase()) ||
                                        actualBook.getBookAuthor().toLowerCase().contains(text.toLowerCase()) ||
                                        actualBook.getBookEditorial().toLowerCase().contains(text.toLowerCase()) ||
                                        actualBook.getBookTitle().toLowerCase().contains(text.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    public void removeBook(String isbn) {
        findBookByIsbn(isbn).ifPresent(books::remove);
    }

    public void updateBook(Book book) {
        if (findBookByIsbn(book.getIsbnCode()).isPresent()) {
           int index = books.indexOf(findBookByIsbn(book.getIsbnCode()).get());
            BookUpdater.updateBook(books.get(index),book); //reemplaza la informacion del objeto sin cambiar referencia
            //books.set(index,book); // reemplaza la referencia
        }
    }

}
