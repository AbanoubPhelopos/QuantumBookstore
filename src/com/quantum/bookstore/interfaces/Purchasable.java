package com.quantum.bookstore.interfaces;

public interface Purchasable {
    String getISBN();
    String getTitle();
    double getPrice();
    boolean isAvailable(int quantity);
    void reduceStock(int quantity);
}
