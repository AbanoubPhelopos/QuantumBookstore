// src/com/quantum/bookstore/models/EBook.java
package com.quantum.bookstore.models;

import com.quantum.bookstore.interfaces.*;
import com.quantum.bookstore.services.*;

public class EBook extends Book implements Purchasable, Emailable, Deliverable {
    private String fileType;

    public EBook(String isbn, String title, String author, int publishYear, double price, String fileType) {
        super(isbn, title, author, publishYear, price);
        this.fileType = fileType;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return true; // EBooks are always available
    }

    @Override
    public void reduceStock(int quantity) {
        // No stock reduction needed for EBooks
    }

    @Override
    public void sendByEmail(String email) {
        MailService.sendEmail(this, email);
    }

    @Override
    public void deliver(String email, String address) {
        sendByEmail(email);
    }

    public String getFileType() { return fileType; }

    @Override
    public String toString() {
        return "Quantum book store - EBook: " + super.toString() + ", File Type: " + fileType;
    }
}
