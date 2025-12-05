package lab7;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibrarySystem {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void addUser(User u) {
        users.add(u);
    }

    public Book findBook(String id) {
        for (Book b : books)
            if (b.getBookID().equals(id))
                return b;
        return null;
    }

    public User findUser(String id) {
        for (User u : users)
            if (u.getUserID().equals(id))
                return u;
        return null;
    }

    public void borrowBook(String userID, String bookID) {
        User u = findUser(userID);
        Book b = findBook(bookID);

        if (u == null || b == null) {
            System.out.println("Borrow FAILED: User or Book not found.");
            return;
        }

        if (!b.isAvailable()) {
            System.out.println("Borrow FAILED: Book already borrowed.");
            return;
        }

        b.setAvailable(false);
        Transaction t = new Transaction(userID, bookID);
        transactions.add(t);

        System.out.println(u.getName() + " borrowed " + b.getTitle());
    }

    public double calculateFine(LocalDate borrowDate, LocalDate returnDate) {
        int days = returnDate.getDayOfYear() - borrowDate.getDayOfYear();
        if (days > 7) {
            return (days - 7) * 1.00;  // RM1 per extra day
        }
        return 0;
    }

    public void returnBook(String userID, String bookID) {
        Book b = findBook(bookID);

        if (b == null) {
            System.out.println("Return FAILED: book not found.");
            return;
        }

        b.setAvailable(true);

        for (Transaction t : transactions) {
            if (t.toString().contains(userID) && t.toString().contains(bookID)) {

                // Force overdue by +10 days (for demo)
                LocalDate today = LocalDate.now().plusDays(10);
                double fine = calculateFine(t.getBorrowDate(), today);

                t.setReturn(today, fine);
                System.out.println("Book Returned. Fine = RM" + fine);
                return;
            }
        }
    }

    public void listTransactions() {
        System.out.println("\n--- TRANSACTIONS ---");
        for (Transaction t : transactions)
            System.out.println(t);
    }
}
