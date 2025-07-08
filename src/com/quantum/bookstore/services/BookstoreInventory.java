package com.quantum.bookstore.services;

import com.quantum.bookstore.models.*;
import com.quantum.bookstore.interfaces.*;
import java.util.*;

public class BookstoreInventory {
    private Map<String, Book> inventory;

    public BookstoreInventory() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Quantum book store - Added: " + book.toString());
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> outdatedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            
            if (book.isOutdated(yearsThreshold)) {
                outdatedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store - Removed outdated book: " + book.getTitle());
            }
        }
        
        return outdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store - Book with ISBN " + isbn + " not found");
        }
        
        if (book instanceof ShowcaseBook) {
            throw new IllegalArgumentException("Quantum book store - Showcase books are not for sale");
        }
        
        if (!(book instanceof Purchasable)) {
            throw new IllegalArgumentException("Quantum book store - Book is not purchasable");
        }
        
        Purchasable purchasableBook = (Purchasable) book;
        
        if (!purchasableBook.isAvailable(quantity)) {
            throw new IllegalArgumentException("Quantum book store - Insufficient stock for " + book.getTitle());
        }
        
        // Process purchase
        purchasableBook.reduceStock(quantity);
        double totalAmount = book.getPrice() * quantity;
        
        // Handle delivery
        if (book instanceof Deliverable) {
            ((Deliverable) book).deliver(email, address);
        }
        
        System.out.println("Quantum book store - Purchase successful: " + quantity + "x " + book.getTitle() + 
                          " for $" + totalAmount);
        
        return totalAmount;
    }

    public void displayInventory() {
        System.out.println("Quantum book store - Current Inventory:");
        System.out.println("=====================================");
        for (Book book : inventory.values()) {
            System.out.println(book.toString());
        }
        System.out.println("=====================================");
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
}
