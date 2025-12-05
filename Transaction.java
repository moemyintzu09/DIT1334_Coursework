package lab7;

import java.time.LocalDate;

public class Transaction {
    private String userID;
    private String bookID;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private double fine;

    public Transaction(String userID, String bookID) {
        this.userID = userID;
        this.bookID = bookID;
        this.borrowDate = LocalDate.now();
    }

    // Getter for borrow date
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setReturn(LocalDate date, double fine) {
        this.returnDate = date;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "User: " + userID +
               ", Book: " + bookID +
               ", Borrowed: " + borrowDate +
               ", Returned: " + returnDate +
               ", Fine: RM" + fine;
    }
}
