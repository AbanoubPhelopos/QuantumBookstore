# Quantum Bookstore 

A comprehensive bookstore management system built in Java that demonstrates all SOLID principles and good Object-Oriented Programming (OOP) design patterns. This project showcases a clean, maintainable, and extensible architecture for handling different types of books, inventory management, and purchase operations.

## 🚀 Features

- **Multi-Type Book Management**: Support for Paper Books, E-Books, and Showcase Books
- **Inventory Management**: Add books, remove outdated books, and track stock levels
- **Purchase System**: Complete buying process with stock validation and delivery
- **Delivery Services**: Automated shipping for paper books and email delivery for e-books
- **Stock Control**: Real-time inventory updates and availability checking
- **Outdated Book Removal**: Automatic identification and removal of old books

## 🏗️ Architecture & Design Patterns

### SOLID Principles Implementation

#### 1. **Single Responsibility Principle (SRP)**
- `Book`: Manages book data and basic operations
- `BookstoreInventory`: Handles inventory management operations
- `ShippingService`: Manages physical shipping operations
- `MailService`: Handles email delivery operations

#### 2. **Open/Closed Principle (OCP)**
- New book types can be added without modifying existing code
- New delivery methods can be implemented without changing core logic
- Payment systems can be extended without altering base classes

#### 3. **Liskov Substitution Principle (LSP)**
- All book subtypes can be used interchangeably where `Book` is expected
- `Purchasable` implementations can be substituted without breaking functionality

#### 4. **Interface Segregation Principle (ISP)**
- `Purchasable`: For books that can be bought
- `Shippable`: For books requiring physical shipping
- `Emailable`: For books that can be sent via email
- `Deliverable`: For books that can be delivered

#### 5. **Dependency Inversion Principle (DIP)**
- High-level modules depend on abstractions (interfaces)
- `BookstoreInventory` depends on `Purchasable` and `Deliverable` interfaces, not concrete implementations


## 📁 Project Structure
```
QuantumBookstore/
├── src/
│ └── com/
│ └── quantum/
│ └── bookstore/
│ ├── QuantumBookstore.java # Main application
│ ├── interfaces/
│ │ ├── Purchasable.java # Interface for purchasable items
│ │ ├── Shippable.java # Interface for shippable items
│ │ ├── Emailable.java # Interface for email delivery
│ │ └── Deliverable.java # Interface for delivery operations
│ ├── models/
│ │ ├── Book.java # Abstract base book class
│ │ ├── PaperBook.java # Physical book implementation
│ │ ├── EBook.java # Digital book implementation
│ │ └── ShowcaseBook.java # Display-only book implementation
│ └── services/
│ ├── BookstoreInventory.java # Inventory management service
│ ├── ShippingService.java # Shipping operations service
│ └── MailService.java # Email delivery service
└── bin/ # Compiled class files
```

## 📋 Usage Example
The test application demonstrates a complete bookstore workflow at the Main
```
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

```

## 📊 Sample Output
```
--- Adding Books ---
Quantum book store - Added: Quantum book store - Paper Book: ISBN: 978-0134685991, Title: Effective Java, Author: Joshua Bloch, Year: 2017, Price: $45.99, Stock: 10
Quantum book store - Added: Quantum book store - Paper Book: ISBN: 978-0132350884, Title: Clean Code, Author: Robert Martin, Year: 2008, Price: $39.99, Stock: 5
Quantum book store - Added: Quantum book store - EBook: ISBN: 978-1234567890, Title: Java Programming Guide, Author: John Doe, Year: 2023, Price: $29.99, File Type: PDF
Quantum book store - Added: Quantum book store - EBook: ISBN: 978-0987654321, Title: Design Patterns, Author: Gang of Four, Year: 2020, Price: $34.99, File Type: EPUB
Quantum book store - Added: Quantum book store - Showcase Book: ISBN: 978-1111111111, Title: Upcoming Java Book, Author: Future Author, Year: 2025, Price: $0.00 (Not for sale)

--- Display Inventory ---
Quantum book store - Current Inventory:
=====================================
Quantum book store - Showcase Book: ISBN: 978-1111111111, Title: Upcoming Java Book, Author: Future Author, Year: 2025, Price: $0.00 (Not for sale)
Quantum book store - EBook: ISBN: 978-0987654321, Title: Design Patterns, Author: Gang of Four, Year: 2020, Price: $34.99, File Type: EPUB
Quantum book store - Paper Book: ISBN: 978-0134685991, Title: Effective Java, Author: Joshua Bloch, Year: 2017, Price: $45.99, Stock: 10
Quantum book store - EBook: ISBN: 978-1234567890, Title: Java Programming Guide, Author: John Doe, Year: 2023, Price: $29.99, File Type: PDF
Quantum book store - Paper Book: ISBN: 978-0132350884, Title: Clean Code, Author: Robert Martin, Year: 2008, Price: $39.99, Stock: 5
=====================================

--- Buying Books ---
Quantum book store - Shipping Effective Java to address: 123 Main St
Quantum book store - Purchase successful: 2x Effective Java for $91.98
Quantum book store - Paid amount: $91.98
Quantum book store - Sending Java Programming Guide to email: customer@email.com
Quantum book store - Purchase successful: 1x Java Programming Guide for $29.99
Quantum book store - Paid amount: $29.99

--- Try to Buy Showcase Book ---
Quantum book store - Expected error: Quantum book store - Showcase books are not for sale

--- Try to Buy Excessive Stock ---
Quantum book store - Expected error: Quantum book store - Insufficient stock for Clean Code

--- Remove Outdated Books ---
Quantum book store - Removed outdated book: Clean Code
Quantum book store - Removed 1 outdated books

--- Final Inventory ---
Quantum book store - Current Inventory:
=====================================
Quantum book store - Showcase Book: ISBN: 978-1111111111, Title: Upcoming Java Book, Author: Future Author, Year: 2025, Price: $0.00 (Not for sale)
Quantum book store - EBook: ISBN: 978-0987654321, Title: Design Patterns, Author: Gang of Four, Year: 2020, Price: $34.99, File Type: EPUB
Quantum book store - Paper Book: ISBN: 978-0134685991, Title: Effective Java, Author: Joshua Bloch, Year: 2017, Price: $45.99, Stock: 8
Quantum book store - EBook: ISBN: 978-1234567890, Title: Java Programming Guide, Author: John Doe, Year: 2023, Price: $29.99, File Type: PDF
=====================================

Quantum book store - Full Test Completed
```
