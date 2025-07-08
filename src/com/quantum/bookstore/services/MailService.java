package com.quantum.bookstore.services;

import com.quantum.bookstore.models.Book;

public class MailService {
    
    public static void sendEmail(Book book, String email) {
        System.out.println("Quantum book store - Sending " + book.getTitle() + " to email: " + email);
    }
}
