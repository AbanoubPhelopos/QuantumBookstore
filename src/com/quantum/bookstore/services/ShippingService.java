package com.quantum.bookstore.services;

import com.quantum.bookstore.models.Book;

public class ShippingService {
    
    public static void ship(Book book, String address) {
        System.out.println("Quantum book store - Shipping " + book.getTitle() + " to address: " + address);
    }
}
