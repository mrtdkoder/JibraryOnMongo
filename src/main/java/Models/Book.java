package Models;

import java.util.Date;

public class Book {
    public int bookId;
    public String title;
    public String author;
    public String description;
    public String type;
    public String location;
    public String language;
    public int stockAmount;
    public boolean isSold;
    public double price;
    public Date releaseDate;

    public Book() {

    }

    public Book(int bookId, String title, String author, String description, String type, String location, String language, int stockAmount, boolean isSold, double price, Date releaseDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.type = type;
        this.location = location;
        this.language = language;
        this.stockAmount = stockAmount;
        this.isSold = isSold;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", language='" + language + '\'' +
                ", stockAmount=" + stockAmount +
                ", isSold=" + isSold +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
