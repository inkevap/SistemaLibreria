package sistemalibreria.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.model.Book;
import static org.junit.jupiter.api.Assertions.*;

public class BookUpdaterTest {

    @DisplayName("updateBook valida valores distintos/validos")
    @Test
    public void updateBook_updatesOnlyValidFields() {
        Book outdated = new Book();
        outdated.setBookTitle("Viejo título");
        outdated.setBookAuthor("Autor antiguo");
        outdated.setBookEditorial("Editorial antigua");
        outdated.setBookAvailability(3);
        outdated.setBookPublishYear(1999);

        Book updated = new Book();
        updated.setBookTitle("Nuevo título");
        updated.setBookAuthor(""); // no válido
        updated.setBookEditorial("Nueva editorial");
        updated.setBookAvailability(-1); // no válido
        updated.setBookPublishYear(2022);

        BookUpdater.updateBook(outdated, updated);

        assertEquals("Nuevo título", outdated.getBookTitle());
        assertEquals("Autor antiguo", outdated.getBookAuthor());
        assertEquals("Nueva editorial", outdated.getBookEditorial());
        assertEquals(3, outdated.getBookAvailability());
        assertEquals(2022, outdated.getBookPublishYear());
    }
}
