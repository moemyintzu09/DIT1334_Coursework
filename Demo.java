package lab7;

public class Demo {
    public static void main(String[] args) {

        LibrarySystem lib = new LibrarySystem();

        // Add sample users
        lib.addUser(new Student("S01", "Ali"));
        lib.addUser(new Librarian("L01", "Ms. Chen"));

        // Add books
        lib.addBook(new Book("B01", "Java Programming"));
        lib.addBook(new Book("B02", "Python Basics"));

        // BORROW
        lib.borrowBook("S01", "B01");  // success
        lib.borrowBook("S01", "B01");  // fail (already borrowed)

        // RETURN (forced overdue)
        lib.returnBook("S01", "B01");

        // SHOW TRANSACTIONS
        lib.listTransactions();
    }
}
