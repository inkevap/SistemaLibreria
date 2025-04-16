package util;

import model.Book;

public class BookUpdater {

    public static void updateBook(Book outdatedBook, Book updatedBook){
        outdatedBook.setBookAvailability(updatedBook.getBookAvailability());
        outdatedBook.setBookEditorial(updatedBook.getBookEditorial());
        outdatedBook.setBookAuthor(updatedBook.getBookAuthor());
        outdatedBook.setBookTitle(updatedBook.getBookTitle());
        outdatedBook.setBookPublishYear(updatedBook.getBookPublishYear());
    }
}
