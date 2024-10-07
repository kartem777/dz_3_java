package library.services;

import library.models.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }
}
