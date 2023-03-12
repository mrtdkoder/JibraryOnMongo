package Views;

import Models.Book;
import Models.BookRepostory;
import Models.User;

import java.util.List;

public class BookView extends View {
    BookRepostory _br = new BookRepostory(true);

    public void showOptionsMenu() {
        while (true) {
            titleBar("User Menu [" + getCurrentUserName() +"]", 0);
            System.out.println("1.Search in books ");
            System.out.println("2.Add new");
            System.out.println("3.Edit");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            int option = readInt("Enter your option: ");
            switch (option) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editEdit();
                    break;
                case 4:
                    deleteBook();
                    break;
                default:
                    break;
            }
            if (option == 5) {break;}
        }
    }

    private void deleteBook() {
        titleBar("Delete Book");
        Book u = _br.getBookById(readInt("Enter book id: ",-1,true));
        if (u != null) {
            _br.remove(u);
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    private void editEdit() {
        titleBar("Edit Book");
        Book b = _br.getBookById(readInt("Enter book id: ",-1,true));
        if (b != null) {
            b.title = readString("Title: ");
            b.author = readString("Author: ");
            b.description = readString("Description: ");
            b.type = readString("Type: ");
            b.location = readString("Location: ");
            b.language = readString("Language: ");
            b.stockAmount = readInt("Stock amount: ", 0, true);
            b.isSold = readInt("Is sold [1/0]: ",0, true)==1;
            b.price = readDouble("Price: ", 0, true);

            _br.update(b.bookId, b);
            System.out.println("Book edited successfully");
        } else {
            System.out.println("Book not found");
        }
    }

    private void addBook() {
        titleBar("New book");
        Book b = new Book();
            b.bookId = _br.getLastBookId()+1;
            b.title = readString("Title: ");
            b.author = readString("Author: ");
            b.description = readString("Description: ");
            b.type = readString("Type: ");
            b.location = readString("Location: ");
            b.language = readString("Language: ");
            b.stockAmount = readInt("Stock amount: ", 0, true);
            b.isSold = readInt("Is sold [1/0]: ",0, true)==1;
            b.price = readDouble("Price: ", 0, true);

            _br.add(b);
            System.out.println("Book edited successfully");

    }

    private void showBooks() {
        titleBar("Books List", 0);
        List<Book> list = _br.searchAllToList(readString("Search in books: "));
        System.out.printf("%5s> %-20s %-20s %-15s %10s %10s \n", "ID", "Name", "Author", "Type", "Stock", "Price");
        buttomBar();
        for(Book b : list) {
            System.out.printf("%5d> %-20s %-20s %-15s %10s %10s \n", b.bookId, b.title,
                    b.author, b.type,b.stockAmount, b.price);
        }
    }
}
