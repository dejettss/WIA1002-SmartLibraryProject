import java.util.Scanner;

public class SmartLibrary implements LibraryADT {

    // --- YOUR SECTION (Foundation & Core Logic) ---
    private BookBST catalogue = new BookBST();
    private BorrowStack history = new BorrowStack();

    @Override
    public void addBook(int isbn, String title, String author) {
        catalogue.insert(isbn, title, author);
        System.out.println("Book added: [" + isbn + "] " + title + " by " + author);
    }

    @Override
    public void searchBook(int isbn) {
        Book b = catalogue.search(isbn);
        if (b != null)
            System.out.println("Found: [ISBN: " + b.isbn + "] " + b.title + " by " + b.author);
        else
            System.out.println("Book with ISBN " + isbn + " not found.");
    }

    @Override
    public void borrowBook(int isbn) {
        Book b = catalogue.search(isbn);
        if (b != null) {
            history.push(b);
            System.out.println("Borrowed: " + b.title);
        } else {
            System.out.println("Book not in catalogue.");
        }
    }

    @Override
    public void viewLatestHistory() {
        history.show();
    }

    // --- RAJA'S SECTION (Console UI & Validation) ---
    // TODO (Raja): implement runMenu(), printMenu(), handleChoice()

    public void runMenu() {
        // TODO (Raja): create Scanner, loop calling printMenu() then handleChoice()
        throw new UnsupportedOperationException("runMenu() not yet implemented - Raja's task");
    }

    private void printMenu() {
        // TODO (Raja): print the numbered menu options
        throw new UnsupportedOperationException("printMenu() not yet implemented - Raja's task");
    }

    private void handleChoice(int choice, Scanner sc) {
        // TODO (Raja): switch on choice, read inputs, call the LibraryADT methods above
        // Remember to wrap ISBN reads in try-catch to handle non-integer input
        throw new UnsupportedOperationException("handleChoice() not yet implemented - Raja's task");
    }
}
