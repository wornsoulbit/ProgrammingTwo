
package task3;

import java.util.Arrays;

/**
 * Class of a Book.
 * 
 * @author Alex Vasil
 */
public class Book {
    private String title;
    private String[] authors;
    private double price;

    /**
     * Constructor with initialized values.
     */
    public Book() {
        title = "random book name";
        authors = new String[]{"Alex", "ebruh"};
        price = 29.99;
    }

    /**
     * Constructor with given values.
     * 
     * @param title Title of the book.
     * @param authors Name of the author(s).
     * @param price Price of the book.
     */
    public Book(String title, String[] authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }
    
    /**
     * Deep copy of a Book.
     * 
     * @param anotherBook Book being copied.
     */
    public Book(Book anotherBook) {
        this.title = anotherBook.title;
        this.price = anotherBook.price;
        String[] copiedAuthors = new String[authors.length];
        System.arraycopy(authors, 0, copiedAuthors, 0, authors.length);
        copiedAuthors = anotherBook.authors;
    }
    
    /**
     * Checks to see if two Books are equal to each other.
     * 
     * @param obj The object being compared.
     * @return If both objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        
        if (!(obj instanceof Author))
            return false;
        
        return this.title.equals(book.title)
                && this.price == book.price
                && Arrays.equals(this.authors, book.authors);
    }

    @Override
    public String toString() {
        String strOut = String.format("%-6s: %-6s\n", "Title", this.title);
        strOut += String.format("%-6s:", "Author(s)");
        for (String author : this.authors)
            strOut += author;
        strOut += String.format("\n%-6s: %.2f\n", "Price", this.price);
        
        return strOut;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
