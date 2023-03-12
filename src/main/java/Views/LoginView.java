package Views;


import Models.User;
import Models.UserRepostory;

public class LoginView extends View {

    public LoginView() {

    }

    public void showMenu() {

    }

    public void showRegister() {
        titleBar("Register", 0);
        String un = readString("Please enter your username: ");
        String pw = readString("Please enter your password: ");
        buttomBar();
    }

    public void showLogin() {
        titleBar("login", 0);
        String un = readString("Username: ");
        String pw = readString("password: ");
        buttomBar();
        UserRepostory _ur = new UserRepostory(true);
        User u = _ur.getUserByUserName(un);
        if (u!= null) {
            if (u.password.equals(pw)&&u.isAdmin==1) {
                HomeView.currentUser = u;
                HomeView hv = new HomeView();
                hv.showOptionsMenu();
            } else {
                titleBar("Access denied", 0);
            }
        } else {
            titleBar("Access denied", 0);
        }

    }

}
