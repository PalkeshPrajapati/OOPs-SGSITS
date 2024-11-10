package LibraryManagementSystem;
import java.util.ArrayList;

class Member {
    String name;
    String memberId;
    ArrayList<Book> borrowedBooks;
    static final int MAX_BORROW_LIMIT = 5;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_BORROW_LIMIT;
    }

    public void borrowBook(Book book) {
        if (canBorrow()) {
            borrowedBooks.add(book);
        } else {
            System.out.println(name + " has reached the maximum borrow limit.");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}