package com.quantum.bookstore;

import com.quantum.bookstore.models.*;
import com.quantum.bookstore.services.*;
import java.util.List;

public class QuantumBookstore {
    public static void main(String[] args) {
        System.out.println("Quantum book store - Starting Full Test");
        System.out.println("========================================");
        
        BookstoreInventory bookstore = new BookstoreInventory();
        
        System.out.println("\n--- Adding Books ---");
        
        PaperBook paperBook1 = new PaperBook("978-0134685991", "Effective Java", "Joshua Bloch", 2017, 45.99, 10);
        PaperBook paperBook2 = new PaperBook("978-0132350884", "Clean Code", "Robert Martin", 2008, 39.99, 5);
        EBook ebook1 = new EBook("978-1234567890", "Java Programming Guide", "John Doe", 2023, 29.99, "PDF");
        EBook ebook2 = new EBook("978-0987654321", "Design Patterns", "Gang of Four", 2020, 34.99, "EPUB");
        ShowcaseBook showcase1 = new ShowcaseBook("978-1111111111", "Upcoming Java Book", "Future Author", 2025);
        
        bookstore.addBook(paperBook1);
        bookstore.addBook(paperBook2);
        bookstore.addBook(ebook1);
        bookstore.addBook(ebook2);
        bookstore.addBook(showcase1);
        
        System.out.println("\n--- Display Inventory ---");
        bookstore.displayInventory();
        


        System.out.println("\n--- Buying Books ---");
        
        try {
            double amount1 = bookstore.buyBook("978-0134685991", 2, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store - Paid amount: $" + amount1);
            
            double amount2 = bookstore.buyBook("978-1234567890", 1, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store - Paid amount: $" + amount2);
            
        } catch (Exception e) {
            System.err.println("Quantum book store - Purchase failed: " + e.getMessage());
        }
        
        
        
        System.out.println("\n--- Try to Buy Showcase Book ---");
        try {
            bookstore.buyBook("978-1111111111", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.err.println("Quantum book store - Expected error: " + e.getMessage());
        }
        




        System.out.println("\n--- Try to Buy Excessive Stock ---");
        try {
            bookstore.buyBook("978-0132350884", 10, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.err.println("Quantum book store - Expected error: " + e.getMessage());
        }
        


        System.out.println("\n--- Remove Outdated Books ---");
        List<Book> outdatedBooks = bookstore.removeOutdatedBooks(10);
        System.out.println("Quantum book store - Removed " + outdatedBooks.size() + " outdated books");
        


        System.out.println("\n--- Final Inventory ---");
        bookstore.displayInventory();
        

        System.out.println("\nQuantum book store - Full Test Completed");
    }
}