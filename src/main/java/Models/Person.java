package Models;


import java.time.LocalDate;
import java.util.Date;

public final class Person {
   // public String _id ;
    public int personId;
    public String fullName;
    public String email;

    public String phone;
    public String address;
    private Date DoB;

    public String getDoB() {
        return DoB.toString();
    }

    public Person(){

    }

    public Person(int id, String fullName, String email, String phone, String address, Date doB) {
        this.personId   = id;
        this.fullName   = fullName;
        this.email      = email;
        this.phone      = phone;
        this.address    = address;
        DoB = doB;
    }

    public void generateId() {
       // _id = " "; //UUID.randomUUID();
    }

    public int getPersonId() {
        return personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                " fullName='" + fullName + "\'" +
                ", email='" + email + "' " +
                ", phone='" + phone + "'" +
                ", address='" + address + "'"+
                ", DoB=" + DoB +
                "}";
    }
}
