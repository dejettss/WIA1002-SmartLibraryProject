public class BookBST {
    private Book root;

    public void insert(int isbn, String title, String author) {
        root = insertRec(root, isbn, title, author);
    }

    private Book insertRec(Book node, int isbn, String title, String author) {
        if (node == null) return new Book(isbn, title, author);
        if (isbn < node.isbn)
            node.left = insertRec(node.left, isbn, title, author);
        else if (isbn > node.isbn)
            node.right = insertRec(node.right, isbn, title, author);
        return node;
    }

    public Book search(int isbn) {
        return searchRec(root, isbn);
    }

    private Book searchRec(Book node, int isbn) {
        if (node == null || node.isbn == isbn) return node;
        return isbn < node.isbn ? searchRec(node.left, isbn) : searchRec(node.right, isbn);
    }

    public void delete(int isbn) {
        root = deleteRec(root, isbn);
    }

    private Book deleteRec(Book node, int isbn) {
        if (node == null) return null;
        if (isbn < node.isbn)
            node.left = deleteRec(node.left, isbn);
        else if (isbn > node.isbn)
            node.right = deleteRec(node.right, isbn);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Book successor = findMin(node.right);
            node.isbn = successor.isbn;
            node.title = successor.title;
            node.author = successor.author;
            node.right = deleteRec(node.right, successor.isbn);
        }
        return node;
    }

    private Book findMin(Book node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
