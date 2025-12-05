package lab7;

public class Book {
    private String bookID;
    private String title;
    private boolean available = true;

    public Book(String bookID, String title) {
        this.bookID = bookID;
        this.title = title;
    }

    public String getBookID() { return bookID; }
    public String getTitle() { return title; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean status) {
        this.available = status;
    }
}
