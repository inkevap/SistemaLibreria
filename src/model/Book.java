package model;

public class Book {
 private String isbnCode;
 private String bookTitle;
 private String bookAuthor;
 private int bookPublishYear;
 private String bookEditorial;
 private String bookAvailability;

    public Book(String isbnCode, String bookTitle,
                String bookAuthor, int bookPublishYear,
                String bookEditorial, String bookAvailability) {
        this.isbnCode = isbnCode;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.bookEditorial = bookEditorial;
        this.bookAvailability = bookAvailability;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookPublishYear() {
        return bookPublishYear;
    }

    public String getBookEditorial() {
        return bookEditorial;
    }

    public String getBookAvailability() {
        return bookAvailability;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublishYear(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public void setBookEditorial(String bookEditorial) {
        this.bookEditorial = bookEditorial;
    }

    public void setBookAvailability(String bookAvailability) {
        this.bookAvailability = bookAvailability;
    }
}
