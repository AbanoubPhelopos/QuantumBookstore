package com.quantum.bookstore.models;

import java.time.LocalDate;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    // Getters
    public String getISBN() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublishYear() { return publishYear; }
    public double getPrice() { return price; }

    public boolean isOutdated(int yearsThreshold) {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - publishYear) > yearsThreshold;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f", 
                           isbn, title, author, publishYear, price);
    }
}
