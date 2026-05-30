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
}
