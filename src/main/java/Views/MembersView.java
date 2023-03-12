package Views;

import Models.Member;
import Models.MemberRepostory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembersView extends View {

    private static MemberRepostory _mr = new MemberRepostory(true);
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
    public void showMembers() {
        titleBar("Members List", 0);
        List<Member> list = _mr.searchAllToList(readString("Search in members: "));
        buttomBar();
        for (Member m : list) {
            System.out.printf("%5d> %-20s %-20s %-15s %10s %10s \n", m.memberId,
                    m.fullName, m.email, m.phone, isAdminToString(m.isAdmin), statusToString(m.status));
        }
        buttomBar();
        showOptionsMenu();
    }

    public void showOptionsMenu() {
        while (true) {
            System.out.println("1.Search in members ");
            System.out.println("2.Add new member");
            System.out.println("3.Edit member");
            System.out.println("4.Delete member");
            System.out.println("5.Exit");
            int option = readInt("Enter your option: ");
            switch (option) {
                case 1:
                    showMembers();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    editMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                default:
                    break;
            }
            if (option == 5) {break;}
        }
    }

    private void deleteMember() {
        titleBar("Delete member");
        Member m = _mr.getMemberById(readInt("Enter member id: ",-1,true));
        if (m != null) {
            _mr.remove(m);
            System.out.println("member deleted successfully");
        } else {
            System.out.println("Member not found");
        }
    }

    private void editMember() {
        titleBar("Edit member");
        Member m = _mr.getMemberById(readInt("Enter member id: ",-1,true));
        if (m != null) {
            m.fullName = readString("Enter full name: ");
            m.email = readString("Enter email: ");
            m.phone = readString("Enter phone: ");
            m.address = readString("Enter address: ");
            m.setDoB(readDate("Enter date of birth: "));
            m.isAdmin = readInt("is admin [0/1]: ");
            m.status = readInt("Status [0=inactive, 1=active, -1=banned]: ");
            m.password = readString("Enter password: ");

            _mr.update(m.memberId, m);
            System.out.println("member edited successfully");
        } else {
            System.out.println("Member not found");
        }
    }

    private void addMember() {
        titleBar("Add new member");
        Member m = new Member();
        m.fullName = readString("Enter full name: ");
        m.email = readString("Enter email: ");
        m.phone = readString("Enter phone: ");
        m.address = readString("Enter address: ");
        m.setDoB(readDate("Enter date of birth: "));
        m.isAdmin = readInt("is admin [0/1]: ");
        m.status = readInt("Status [0=inactive, 1=active, -1=banned]: ");
        m.password = readString("Enter password: ");

        _mr.add(m);
        System.out.println("new member created");
    }
}
