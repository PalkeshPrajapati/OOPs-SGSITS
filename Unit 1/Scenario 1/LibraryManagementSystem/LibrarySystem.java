package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;

public class LibrarySystem {
    ArrayList<Book> books;
    ArrayList<Member> members;
    ArrayList<Loan> loans;

    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    // Show all books
    public void showAllBooks(){
        for (Book book : books) {
            System.out.println(book.isbn + ": " + book.title + " by " + book.author + ((book.isAvailable)?" (Available)":" (Not Available)"));
        }
    }

    // Show all Members
    public void showAllMembers(){
        for (Member member : members) {
            System.out.println(member.memberId + ": " + member.name);
        }
    }

    // Show all Loans
    public void showAllLoans(){
        for (Loan loan : loans) {
            System.out.println(loan.book.title + " borrowed by " + loan.member.name + " on " + loan.borrowDate + ((loan.returnDate == null)?" (NotReturned)":(" & returened on " + loan.returnDate)));
        }
    }


    // Add a new book to the system
    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
    }

    // Register a new member
    public void registerMember(String name, String memberId) {
        members.add(new Member(name, memberId));
    }

    // Borrow a book
    public void borrowBook(String isbn, String memberId) {
        Book bookToBorrow = findBook(isbn);
        Member member = findMember(memberId);

        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!bookToBorrow.isAvailable) {
            System.out.println("The book is currently unavailable.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (member.canBorrow()) {
            bookToBorrow.borrowBook();
            member.borrowBook(bookToBorrow);
            loans.add(new Loan(bookToBorrow, member, new Date()));
            System.out.println(member.name + " borrowed " + bookToBorrow.title);
        } else {
            System.out.println("Member has reached the maximum borrow limit.");
        }
    }

    // Return a book
    public void returnBook(String isbn, String memberId) {
        Book bookToReturn = findBook(isbn);
        Member member = findMember(memberId);

        if (bookToReturn == null || member == null) {
            System.out.println("Invalid book or member.");
            return;
        }

        Loan loanToReturn = findLoan(bookToReturn, member);
        if (loanToReturn != null) {
            loanToReturn.returnBook(new Date());
            bookToReturn.returnBook();
            member.returnBook(bookToReturn);
            System.out.println(member.name + " returned " + bookToReturn.title);
        } else {
            System.out.println("Loan not found.");
        }
    }

    // Find a book by its ISBN
    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Find a member by their ID
    private Member findMember(String memberId) {
        for (Member member : members) {
            if (member.memberId.equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    // Find the loan by the book and member
    private Loan findLoan(Book book, Member member) {
        for (Loan loan : loans) {
            if (loan.book.equals(book) && loan.member.equals(member) && loan.returnDate == null) {
                return loan;
            }
        }
        return null;
    }
}
