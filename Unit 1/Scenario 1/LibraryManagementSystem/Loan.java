package LibraryManagementSystem;
import java.util.Date;

class Loan {
    Book book;
    Member member;
    Date borrowDate;
    Date returnDate;

    public Loan(Book book, Member member, Date borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public void returnBook(Date returnDate) {
        this.returnDate = returnDate;
    }
}