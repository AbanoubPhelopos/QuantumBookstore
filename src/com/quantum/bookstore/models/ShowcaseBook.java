package com.quantum.bookstore.models;

public class ShowcaseBook extends Book {
    
    public ShowcaseBook(String isbn, String title, String author, int publishYear) {
        super(isbn, title, author, publishYear, 0.0); // Not for sale, price is 0
    }

    @Override
    public String toString() {
        return "Quantum book store - Showcase Book: " + super.toString() + " (Not for sale)";
    }
}
