package sistemalibreria.model;

public class Book {
 private String isbnCode;
 private String bookTitle;
 private String bookAuthor;
 private String bookPublishYear;
 private String bookEditorial;
 private int bookAvailability;

    public Book(String bookTitle,
                String bookAuthor,
                String bookEditorial,
                String bookPublishYear,
                String isbnCode,
                int bookAvailability) {
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
        this.bookPublishYear = "";
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

    public String getBookPublishYear() {
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

    public void setBookPublishYear(String bookPublishYear) {
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
