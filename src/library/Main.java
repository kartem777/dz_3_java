package library;
import library.models.*;
import library.services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library<Book> library = new Library<>();
        List<User> users = new ArrayList<>();
        LibraryService libraryService = new LibraryService(library, users);

        Book book1 = new Book("aaadsfasdaa", "a", "12345");
        Book book2 = new Book("adfsaadsf", "b", "123");

        libraryService.addBook(book1);
        libraryService.addBook(book2);

        User user1 = new User("user1", 1);
        User user2 = new User("user2", 2);

        users.add(user1);
        users.add(user2);

        try {
            libraryService.lendBook(user1, book1);
            System.out.println(user1.getName() + " borrowed: " + book1.getBookInfo());
            libraryService.lendBook(user2, book1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        libraryService.returnBook(user1, book1);
        System.out.println(user1.getName() + " returned: " + book1.getBookInfo());

        System.out.println("Available books: ");
        libraryService.getAvailableBooks().forEach(book -> System.out.println(book.getBookInfo()));
    }
}
