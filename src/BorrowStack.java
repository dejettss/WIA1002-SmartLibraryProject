import java.util.Stack;

// --- AHMAD'S SECTION (Stack & Borrow Logic) ---
// Contract with SmartLibrary:
//   push(Book b)  - called by SmartLibrary.borrowBook() to record a borrow
//   show()        - called by SmartLibrary.viewLatestHistory() to print LIFO order
public class BorrowStack {
    private Stack<Book> stack = new Stack<>();

    public void push(Book b) {
        stack.push(b);
    }

    public void show() {
        if (stack.isEmpty()) {
            System.out.println("History is empty.");
            return;
        }
        System.out.println("Borrow History (most recent first):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            Book b = stack.get(i);
            System.out.println("  [ISBN: " + b.isbn + "] " + b.title);
        }
    }
}