import java.util.Stack;

// --- AHMAD'S SECTION (Stack & Borrow Logic) ---
// Contract with SmartLibrary:
//   push(Book b)  - called by SmartLibrary.borrowBook() to record a borrow
//   show()        - called by SmartLibrary.viewLatestHistory() to print LIFO order
public class BorrowStack {
    private Stack<Book> stack = new Stack<>();

    public void push(Book b) {
        // TODO (Ahmad): push book onto the stack
        throw new UnsupportedOperationException("push() not yet implemented - Ahmad's task");
    }

    public void show() {
        // TODO (Ahmad): if stack is empty print "History is empty."
        // Otherwise iterate from top (most recent) to bottom and print each book's ISBN and title
        throw new UnsupportedOperationException("show() not yet implemented - Ahmad's task");
    }
}
