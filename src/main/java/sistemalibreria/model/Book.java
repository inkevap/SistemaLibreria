package sistemalibreria.model;

public class Book {
 private String isbnCode;
 private String bookTitle;
 private String bookAuthor;
 private int bookPublishYear;
 private String bookEditorial;
 private int bookAvailability;

    public Book(String isbnCode, String bookTitle,
                String bookAuthor, int bookPublishYear,
                String bookEditorial, int bookAvailability) {
        this.isbnCode = isbnCode;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.bookEditorial = bookEditorial;
        this.bookAvailability = bookAvailability;
    }

    public Book(){
        this.isbnCode = "";
        this.bookTitle = "";
        this.bookAuthor = "";
        this.bookPublishYear = -1;
        this.bookEditorial = "";
        this.bookAvailability = -1;
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

    public int getBookAvailability() {
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

    public void setBookAvailability(int bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    @Override
    public String toString() {
        return "Book{ " +
                "isbnCode='" + isbnCode + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublishYear=" + bookPublishYear +
                ", bookEditorial='" + bookEditorial + '\'' +
                ", bookAvailability=" + bookAvailability +
                ", reference=" + super.toString() +
                '}';
    }
}
