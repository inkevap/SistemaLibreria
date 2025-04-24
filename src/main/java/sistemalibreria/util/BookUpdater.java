package sistemalibreria.util;

import sistemalibreria.model.Book;

public class BookUpdater {

    public static void updateBook(Book outdatedBook, Book updatedBook){
        if(updatedBook.getBookAvailability() != -1){
            outdatedBook.setBookAvailability(updatedBook.getBookAvailability());
        }
        if(!updatedBook.getBookEditorial().isBlank()) {
            outdatedBook.setBookEditorial(updatedBook.getBookEditorial());
        }
        if(!updatedBook.getBookAuthor().isBlank()) {
            outdatedBook.setBookAuthor(updatedBook.getBookAuthor());
        }
        if(!updatedBook.getBookTitle().isBlank()) {
            outdatedBook.setBookTitle(updatedBook.getBookTitle());
        }
        if(updatedBook.getBookPublishYear() != -1) {
            outdatedBook.setBookPublishYear(updatedBook.getBookPublishYear());
        }
        }
}
