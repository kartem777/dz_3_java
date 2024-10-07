package library.services;

import library.models.Book;
import library.models.User;

import java.util.List;

public class LibraryService {
    private Library<Book> library;
    private List<User> users;

    public LibraryService(Library<Book> library, List<User> users) {
        this.library = library;
        this.users = users;
    }

    public void addBook(Book book) {
        library.addItem(book);
    }

    public void lendBook(User user, Book book) {
        user.borrowBook(book);
    }

    public void returnBook(User user, Book book) {
        user.returnBook(book);
    }

    public List<Book> getAvailableBooks() {
        return library.getItems().stream()
                .filter(Book::isAvailable)
                .toList();
    }

    public List<User> getUsersWithBorrowedBooks() {
        return users.stream()
                .filter(user -> !user.getBorrowedBooks().isEmpty())
                .toList();
    }
}
