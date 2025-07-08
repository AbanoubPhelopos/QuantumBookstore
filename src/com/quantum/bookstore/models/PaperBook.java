package com.quantum.bookstore.models;

import com.quantum.bookstore.interfaces.*;
import com.quantum.bookstore.services.*;

public class PaperBook extends Book implements Purchasable, Shippable, Deliverable {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publishYear, double price, int stock) {
        super(isbn, title, author, publishYear, price);
        this.stock = stock;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    @Override
    public void reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock for " + title);
        }
    }

    @Override
    public void ship(String address) {
        ShippingService.ship(this, address);
    }

    @Override
    public void deliver(String email, String address) {
        ship(address);
    }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Quantum book store - Paper Book: " + super.toString() + ", Stock: " + stock;
    }
}
