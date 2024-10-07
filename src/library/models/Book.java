package library.models;

public class Book extends LibraryItem implements Borrowable {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getBookInfo() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new BookUnavailableException("The book is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
