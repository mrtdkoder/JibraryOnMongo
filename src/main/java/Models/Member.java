package Models;


import java.util.Date;

public class Member {
   // public String _id ;
    public int memberId;
    public String fullName;
    public String email;

    public String phone;
    public String address;
    private Date DoB;

    public int isAdmin = 0; // 0 = member, 1 = admin, 2+ = root
    public String password;
    public int status; // 0 = inactive, 1 = active, -1=banned
    public String getDoB() {
        return DoB.toString();
    }
    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }

    public Member(){

    }

    public Member(int memberId, String fullName, String email, String phone, String address, Date doB, int isAdmin, String password, int status) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        DoB = doB;
        this.isAdmin = isAdmin;
        this.password = password;
        this.status = status;
    }


    public void generateId() {
       // _id = " "; //UUID.randomUUID();
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId:" + memberId +
                " fullName:'" + fullName + "\'" +
                ", email:'" + email + "' " +
                ", phone:'" + phone + "'" +
                ", address:'" + address + "'"+
                ", DoB:" + DoB +
                "}";
    }
}
