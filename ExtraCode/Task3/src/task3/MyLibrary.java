
package task3;

import java.util.Random;

/**
 * Class of a Library.
 * 
 * @author Alex Vasil
 */
public class MyLibrary {
    private Book[] book;

    public MyLibrary() {
        book = new Book[1];
    }
    
    public MyLibrary(Book[] book) {
        this.book = book;
    }
    
    /**
     * Selects a random book in the library.
     * 
     * @return A randomly selected book in the library.
     */
    public Book selectBook() {
        Random rand = new Random();
        int nextBookNum = rand.nextInt(book.length) - 1;
        return book[nextBookNum];
    }
    
    /**
     * Returns a book at idx.
     * 
     * @param idx The book selected.
     * @return The selected book
     */
    public Book selectBook(int idx) {
        if (idx < 0 || idx > book.length)
            throw new IllegalArgumentException("Idx is out of range of the array.");
        return book[idx];
    }
    
    /**
     * Calculates the total price of all books in the library.
     * 
     * @return The total price of all books in the library.
     */
    public double calcTotalPrice() {
        double totalPrice = 0;
        for (Book books : book)
            totalPrice += books.getPrice();
        return totalPrice;
    }
    
}
