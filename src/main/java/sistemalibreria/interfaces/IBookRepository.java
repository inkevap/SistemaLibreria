package sistemalibreria.interfaces;

import sistemalibreria.model.Book;
import java.util.List;
import java.util.Optional;

public interface IBookRepository {

    public void addBook(Book book);

    public Optional<Book> findBookByIsbn(String isbn);

    public List<Book> findBookByText(String text);

    public void removeBook(String isbn);

    public void updateBook(Book book);

    public List<Book> findAllBooks(); // – para obtener todos los libros.

    public boolean existsByIsbn(String isbn); // – para validaciones.

    public List<Book> findBooksByAuthor(String author);

    public long countBooks(); //para estadísticas.*/
}
