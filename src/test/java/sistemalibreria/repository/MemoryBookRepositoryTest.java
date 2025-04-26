package sistemalibreria.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.interfaces.IBookRepository;
import sistemalibreria.model.Book;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryBookRepositoryTest {
    IBookRepository dbBooks = new MemoryBookRepository();
    Book book01;
    Book book02;
    Book book03;
    Book book04;
    Book book05;
    Book book06;
    Book book07;
    Book book08;
    Book book09;
    Book book10;
    @BeforeEach
    public void MemoryBookRepositorySetup(){
        book01 = new Book();
        book01.setBookTitle("El Jardín de los Sueños");
        book01.setBookAuthor("Sofía Martínez");
        book01.setBookEditorial("Editorial Horizonte");
        book01.setBookPublishYear("1978");
        book01.setIsbnCode("978-3-16-148410-0");
        book01.setBookAvailability(12);

        book02 = new Book();
        book02.setBookTitle("Sombras del Ayer");
        book02.setBookAuthor("Carlos Ramírez");
        book02.setBookEditorial("Ediciones Aurora");
        book02.setBookPublishYear("2003");
        book02.setIsbnCode("978-0-59-600920-5");
        book02.setBookAvailability(7);

        book03 = new Book();
        book03.setBookTitle("Misterios del Abismo");
        book03.setBookAuthor("Lucía Navarro");
        book03.setBookEditorial("Publicaciones Solaris");
        book03.setBookPublishYear("2015");
        book03.setIsbnCode("978-1-84-800123-2");
        book03.setBookAvailability(3);

        book04 = new Book();
        book04.setBookTitle("El Eco de las Montañas");
        book04.setBookAuthor("Fernando Duarte");
        book04.setBookEditorial("Grupo Editorial Alba");
        book04.setBookPublishYear("1992");
        book04.setIsbnCode("978-1-49-191039-9");
        book04.setBookAvailability(18);

        book05 = new Book();
        book05.setBookTitle("Amanecer de Hielo");
        book05.setBookAuthor("María González");
        book05.setBookEditorial("Editorial Estrella");
        book05.setBookPublishYear("2022");
        book05.setIsbnCode("978-0-13-110362-7");
        book05.setBookAvailability(5);

        book06 = new Book(
                "La Sombra del Viento",
                "Adrián Salinas",
                "Editorial Boreal",
                "1987",
                "978-0-19-853453-5",
                9
        );

        book07 = new Book(
                "Caminos Invisibles",
                "Elena Torres",
                "Ediciones Ámbar",
                "1999",
                "978-0-201-03801-9",
                22
        );

        book08 = new Book(
                "El Último Guardián",
                "Marco Vélez",
                "Editorial Nova",
                "2010",
                "978-0-596-52068-7",
                14
        );

        book09 = new Book(
                "Secretos de la Luna",
                "Valeria Domínguez",
                "Luz de Papel Editorial",
                "1975",
                "978-1-60309-452-8",
                4
        );

        book10 = new Book(
                "Susurros del Bosque",
                "Daniel Rivas",
                "Alianza Literaria",
                "2024",
                "978-0-262-13472-9",
                19
        );

        dbBooks.addBook(book01);
        dbBooks.addBook(book02);
        dbBooks.addBook(book03);
        dbBooks.addBook(book04);
        dbBooks.addBook(book05);
        dbBooks.addBook(book06);
        dbBooks.addBook(book07);
        dbBooks.addBook(book08);
        dbBooks.addBook(book09);
        dbBooks.addBook(book10);
    }

    @DisplayName("Añade libros satisfactoriamente")
    @Test
    public void addBooks_AddBooksToTheDB(){
        assertEquals(10, dbBooks.findAllBooks().size());
    }

    @DisplayName("Evita añadir duplicados")
    @Test
    public void addBooks_DontAddDuplicatedBooks(){
        dbBooks.addBook(book01);
        assertEquals(10, dbBooks.findAllBooks().size());
    }

    @DisplayName("Busca el libro por su ISBN")
    @Test
    public void findBookByISBN_FindsBookWithISBN(){
        var bookFound = dbBooks.findBookByIsbn("978-0-262-13472-9");
        if(bookFound.isPresent()){
            assertEquals("Susurros del Bosque", bookFound.get().getBookTitle());
        }else {
            fail("El libro no fue encontrado aunque si fue añadido");
        }
    }

    @DisplayName("Devuelve un optional vacio si no encuentra buscando un libro por su ISBN")
    @Test
    public void findBookByISBN_ReturnsEmptyOptionalWhenDoesntFindBookWithISBN(){
        var bookFound = dbBooks.findBookByIsbn("XXX-0-262-XXXXX-9");
        assertTrue(bookFound.isEmpty());
    }

    @DisplayName("Encuentra libros usando distintos parametros")
    @Test
    public void findBooksByText_FindsAll(){
        //Busca for Nombre del libro
        var booksFound = dbBooks.findBooksByText("Sombra");
        if(!booksFound.isEmpty()){
            assertEquals(2, booksFound.size());
        }else {
            fail("No encuentra los libros por titulo, cuando hay 2");
        }

        //Busca por autor (nombre o una parte lol)
        booksFound = dbBooks.findBooksByText("ez");
        if(!booksFound.isEmpty()){
            assertEquals(5, booksFound.size());
        }else {
            fail("No encuentra los libros por autor, cuando hay 5");
        }

        //Busca for año de publicacion
        booksFound = dbBooks.findBooksByText("2010");
        if(!booksFound.isEmpty()){
            assertEquals(1, booksFound.size());
            assertEquals("El Último Guardián", booksFound.getFirst().getBookTitle());
        }else {
            fail("No encuentra los libros por año, cuando hay 1");
        }

        //busca por editorial
        booksFound = dbBooks.findBooksByText("Editorial Bor");
        if(!booksFound.isEmpty()){
            assertEquals(1, booksFound.size());
            assertEquals("978-0-19-853453-5", booksFound.getFirst().getIsbnCode());
        }else {
            fail("No encuentra los libros por editorial, cuando hay 1");
        }

        //busca por ISBN
        booksFound = dbBooks.findBooksByText("978-1-60309-452-8");
        if(!booksFound.isEmpty()){
            assertEquals(1, booksFound.size());
            assertEquals("Secretos de la Luna", booksFound.getFirst().getBookTitle());
        }else {
            fail("No encuentra los libros por ISBN, cuando hay 1");
        }

        //busca por un dato no registrado, regresa una lista vacia
        booksFound = dbBooks.findBooksByText("978-1-XXXXX-452-8");
        assertTrue(booksFound.isEmpty());

    }

    @DisplayName("Elimina el libro por el ISBN")
    @Test
    public void removeBook_RemovesBookWhenProvidedIsbn(){
        var bookRemoved = dbBooks.findBooksByText("Alianza Literaria");
        if(!bookRemoved.isEmpty()){
            dbBooks.removeBook(bookRemoved.getFirst().getIsbnCode());
        }
        bookRemoved = dbBooks.findBooksByText("Alianza Literaria");
        assertEquals(0, bookRemoved.size());
        assertEquals(9, dbBooks.findAllBooks().size());
    }

    @DisplayName("No elimina libros si no encuentra el ISBN")
    @Test
    public void removeBook_DontRemoveBooksWhenProvidedWrongIsbn(){
        dbBooks.removeBook("978-1-XXXXX-452-8");
        assertEquals(10, dbBooks.findAllBooks().size());
    }

    @DisplayName("Devuelve todos los libros almacenados")
    @Test
    public void findAllBooks(){
        assertEquals(10, dbBooks.findAllBooks().size());
    }

    @DisplayName("Verifica si el libro existe por su ISBN")
    @Test
    public void existsByIsbn_ReturnsABooleanValue(){
        assertTrue(dbBooks.existsByIsbn("978-0-19-853453-5"));
        assertFalse(dbBooks.existsByIsbn("978-0-XX-853453-X"));
    }

    @DisplayName("Devuelve un listado de libros escritos por el mismo autor")
    @Test
    public void findBooksByAuthor_ReturnsAListOfBooksOfTheSameAuthor(){
        assertEquals(5, dbBooks.findBooksByAuthor("ez").size());
        assertEquals(0, dbBooks.findBooksByAuthor("Gaston").size());
    }

    @DisplayName("Devuelve la cantidad actual de libros en la base de datos")
    @Test
    public void countBooks_ReturnsTheAmountOfBooksSaved(){
        assertEquals(10, dbBooks.countBooks());
        dbBooks.findBookByIsbn("978-0-19-853453-5").ifPresent(u -> dbBooks.removeBook(u.getIsbnCode()));
        assertEquals(9, dbBooks.countBooks());
    }

}
