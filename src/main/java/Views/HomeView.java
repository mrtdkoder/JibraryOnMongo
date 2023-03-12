package Views;

import Models.User;

public class HomeView extends View {
    private BookView bv = new BookView();
    private UsersView uv = new UsersView();
    private LoginView lv = new LoginView();

    public static User currentUser= new User();
    public HomeView() {
        if (currentUser.userId>0) {
            showOptionsMenu();
        } else {
            showHome();
        }
    }

    public void showOptionsMenu() {
        while (true) {
            titleBar("menim meyin Menum [" + getCurrentUserName() +"]", 0);
            System.out.println("1.Users ");
            System.out.println("2.Books");
            System.out.println("5.Exit");
            int option = readInt("Enter your option: ");
            switch (option) {
                case 1:
                    uv.showOptionsMenu();
                    break;
                case 2:
                    bv.showOptionsMenu();
                    break;
                default:
                    break;
            }
            if (option == 5) {break;}
        }
    }

    public void showHome() {
        while (true) {
            titleBar("Welcome",0);
            System.out.println("1.Login [not working yet!]");
            System.out.println("2.Register [not working yet!]");
            titleBar("Admin Login",0);
            System.out.println("3.Admin Login (root/1234)");
            System.out.println("4.Exit");
            buttomBar();
            int option = readInt("Enter your option: ");
            switch (option) {
                case 1:
                    //showUsers();
                    break;
                case 2:
                    //addUser();
                    break;
                case 3:
                    lv.showLogin();
                    break;
                default:
                    break;
            }
            if (option == 4) {break;}

        }

    }
}
