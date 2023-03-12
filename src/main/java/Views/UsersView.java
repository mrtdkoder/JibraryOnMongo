package Views;

import Models.User;
import Models.UserRepostory;

import java.util.List;

public class UsersView extends  View {
    private UserRepostory _ur = new UserRepostory(true);

    public String isAdminToString(int a) {
        return (a == 0)? "Member" : "Admin";
    }
    public String statusToString(int s) {
        switch (s) {
            case -1: return "Banned";
            case 0: return "not Active";
            case 1: return "Active";
            default: return "Unknown";
        }
    }

    public void showUsers() {
        titleBar("Users List", 0);
        List<User> list = _ur.searchAllToList(readString("Search in Users: "));
        System.out.printf("%5s> %-20s %-20s %-15s %10s %10s \n", "ID", "Name", "Email", "Phone", "Admin", "Status");
        buttomBar();
        for(User u : list) {
            System.out.printf("%5d> %-20s %-20s %-15s %10s %10s \n", u.userId, u.fullName,
                    u.email, u.phone,isAdminToString(u.isAdmin), statusToString(u.status));
        }
    }

    public void showOptionsMenu() {
        while (true) {
            titleBar("User Menu [" + getCurrentUserName() +"]", 0);
            System.out.println("1.Search in Users ");
            System.out.println("2.Add new");
            System.out.println("3.Edit");
            System.out.println("4.Delete");
            System.out.println("5.Exit");
            int option = readInt("Enter your option: ");
            switch (option) {
                case 1:
                    showUsers();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    editUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                default:
                    break;
            }
            if (option == 5) {break;}
        }
    }

    private void deleteUser() {
        titleBar("Delete user");
        User u = _ur.getUserById(readInt("Enter user id: ",-1,true));
        if (u != null) {
            _ur.remove(u);
            System.out.println("member deleted successfully");
        } else {
            System.out.println("Member not found");
        }
    }

    private void editUser() {
        titleBar("Edit member");
        User u = _ur.getUserById(readInt("Enter user id: ",-1,true));
        if (u != null) {
            u.fullName = readString("Enter full name: ");
            u.email = readString("Enter email: ");
            u.phone = readString("Enter phone: ");
            u.address = readString("Enter address: ");
           // u.setDoB(readDate("Enter date of birth: "));
            u.isAdmin = readInt("is admin [0/1]: ");
            u.status = readInt("Status [0=inactive, 1=active, -1=banned]: ");
            u.password = readString("Enter password: ");

            _ur.update(u.userId, u);
            System.out.println("user edited successfully");
        } else {
            System.out.println("user not found");
        }
    }

    private void addUser() {
        titleBar("Add new USER");
        User u = new User();
        u.userId = _ur.getLastUserId()+1;
        u.fullName = readString("Enter full name: ");
        u.email = readString("Enter email: ");
        u.phone = readString("Enter phone: ");
        u.address = readString("Enter address: ");
        //u.setDoB(readDate("Enter date of birth: "));
        u.isAdmin = readInt("is admin [0/1]: ");
        u.status = readInt("Status [0=inactive, 1=active, -1=banned]: ");
        u.password = readString("Enter password: ");

        _ur.add(u);
        System.out.println("new user created");
    }

}
