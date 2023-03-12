package Models;

import java.util.Date;

public class User {
    public int userId;
    public String fullName;
    public String email;
    public String password;
    public String phone;
    public String address;
   /* public Date DoB;

    public void setDoB(Date readDate) {
        this.DoB = readDate;
    }*/
    public int isAdmin=0; // 0 = member, 1 = admin, 2+ = root
    public int status; // 0 = inactive, 1 = active, -1=banned

    public User() {
    }

    public User(int userId, String fullName, String email, String password, String phone, String address, Date doB, int isAdmin, int status) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        //DoB = doB;
        this.isAdmin = isAdmin;
        this.status = status;
    }

    @Override
    public String toString() {
        return "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
               // ", DoB=" + DoB +
                ", isAdmin=" + isAdmin +
                ", status=" + status +
                '}';
    }


}
