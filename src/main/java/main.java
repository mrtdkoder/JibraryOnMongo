import Models.Book;
import Models.BookRepostory;
import Views.LoginScreen;
import Views.View;

import java.util.Date;
import java.util.Scanner;

public class main {
    public static Scanner input = new Scanner(System.in);
    public static BookRepostory br = new BookRepostory(true);
    public static void main(String[] args) {

        View v = new View();
        v.title = "Book List";
        v.titleBar("",0);

        for (int i = 0; i < 3 ; i++) {
            System.out.println(v.readInt(i + "sayi giriniz: ",0,true));
        }
        System.out.println(v.readDate("Dob:"));
        v.buttomBar();

        LoginScreen ls = new LoginScreen();
        ls.showMenu();
        /*loginScreen();
        showBookList();
        showDeleteBookScreen();
        showBookList();*/

    }

    private static void showDeleteBookScreen() {
        System.out.println("enter the book id you want to delete:");
        int id = input.nextInt();
        br.remove(br.getBookById(id));
    }

    private static void showBookList() {
        for (Book b : br.getAll()) {
            System.out.printf("%4d- %s %s %tF %f \n", b.bookId,
                    b.title, b.author, b.releaseDate, b.price);
        }
        System.out.println("");
    }

    public static void add10books() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book(0,"title"+i, "author"+i, "description", "bio",
                    "floor1.aisle2", "english",1,
                    false,10.0f,new Date());
            br.add(book);
        }
    }
    private static void loginScreen() {
        System.out.println("---------Jibrary--------------");
        System.out.println("|     Welcome to Jibrary      |");
        System.out.println("| press enter   to continue   |");
        System.out.println("------------------------------");
        input.nextLine();
    }
}
