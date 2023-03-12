package Views;

import java.util.Scanner;

public class LoginScreen extends View {
    Scanner input;
    public LoginScreen() {
        input = new Scanner(System.in);
    }

    public void showMenu() {
        titleBar(0);
        System.out.println("1.Login");
        System.out.println("2.Register");
        buttomBar();
        if (readInt("Please enter your choice: ") == 1) {
            showLogin();
        } else {
            showRegister();
        }
    }

    public void showRegister() {
        titleBar("Register", 0);
        String un = readString("Please enter your username: ");
        String pw = readString("Please enter your password: ");
        buttomBar();
    }

    public void showLogin() {
        titleBar("login", 0);
        String un = readString("Please enter your username: ");
        String pw = readString("Please enter your password: ");
        buttomBar();
    }

}
