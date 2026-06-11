import java.util.Scanner;

public class SmartLibrary implements LibraryADT {

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
            catalogue.delete(isbn);
            System.out.println("Borrowed: " + b.title);
        } else {
            System.out.println("Book not in catalogue.");
        }
    }

    @Override
    public void returnBook(int isbn) {
        Book b = history.remove(isbn);
        if (b != null) {
            catalogue.insert(b.isbn, b.title, b.author);
            System.out.println("Returned: " + b.title);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found in borrow history.");
        }
    }

    @Override
    public void viewLatestHistory() {
        history.show();
    }      

    public void runMenu() {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();

            try {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 6) {
                    System.out.println("Exiting Smart Library...");
                    running = false;
                } else {
                    handleChoice(choice, sc);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1-5.");
            }
        }

        sc.close();
    }

    private void printMenu() {
        System.out.println("\n--- Smart Library Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book by ISBN");
        System.out.println("3. Borrow Book by ISBN");
        System.out.println("4. Return Book by ISBN");
        System.out.println("5. View Latest Borrow History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(int choice, Scanner sc) {
         switch (choice) {

         case 1:
            try {
                System.out.print("Enter ISBN: ");
                int isbn = Integer.parseInt(sc.nextLine());

                if (isbn <= 0) {
                    System.out.println("ISBN must be a positive integer.");
                    return;
                }

                // Check duplicate ISBN
                if (catalogue.search(isbn) != null) {
                    System.out.println("A book with ISBN " + isbn + " already exists.");
                    return;
                }

                System.out.print("Enter Title: ");
                String title = sc.nextLine().trim();

                System.out.print("Enter Author: ");
                String author = sc.nextLine().trim();

                if (title.isEmpty() || author.isEmpty()) {
                    System.out.println("Title and Author cannot be empty.");
                    return;
                }

                addBook(isbn, title, author);

            } catch (NumberFormatException e) {
                System.out.println("ISBN must be an integer.");
            }
            break;

         case 2:
            try {
                System.out.print("Enter ISBN to search: ");
                int isbn = Integer.parseInt(sc.nextLine());

                if (isbn <= 0) {
                    System.out.println("ISBN must be a positive integer.");
                    return;
                }

                searchBook(isbn);

            } catch (NumberFormatException e) {
                System.out.println("ISBN must be an integer.");
            }
            break;

         case 3:
            try {
                System.out.print("Enter ISBN to borrow: ");
                int isbn = Integer.parseInt(sc.nextLine());

                if (isbn <= 0) {
                    System.out.println("ISBN must be a positive integer.");
                    return;
                }

                borrowBook(isbn);

            } catch (NumberFormatException e) {
                System.out.println("ISBN must be an integer.");
            }
            break;

         case 4:
            try {
                System.out.print("Enter ISBN to return: ");
                int isbn = Integer.parseInt(sc.nextLine());

                if (isbn <= 0) {
                    System.out.println("ISBN must be a positive integer.");
                    return;
                }

                returnBook(isbn);

            } catch (NumberFormatException e) {
                System.out.println("ISBN must be an integer.");
            }
            break;

         case 5:
            viewLatestHistory();
            break;

         default:
            System.out.println("Invalid choice. Please select between 1 and 6.");
         }
    }
}
