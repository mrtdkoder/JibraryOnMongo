package Models;

import DAO.JibraryDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MemberRepostory {
    private List<Member> _list = new ArrayList<Member>();
    private JibraryDatabase remote_database=null;


    public MemberRepostory() {
        // local only mode
    }
    public MemberRepostory(boolean isRemote) {
        if (isRemote) {
            remote_database = new JibraryDatabase();
            _list = remote_database.loadPersonList();
        }
    }

    public boolean isRemote() {
        return (remote_database!=null);
    }

    public int getLastPersonId() {
        //return Collections.max(_data, Comparator.comparing(Person::getPersonId)).getPersonId();
        int max_id = 0;
        for (int i = 0; i< _list.size(); i++) {
            if (_list.get(i).getMemberId()>max_id) {
                max_id = _list.get(i).getMemberId();
            }
        }
        return max_id;
    }

    public void syncRemote() {
        if (isRemote()) {
            _list = remote_database.loadPersonList();
        }
    }

    public void add(Member member) {
        if (member.memberId <1) {
            member.memberId =getLastPersonId()+1;}
        _list.add(member);
        if (isRemote()) {remote_database.addMember(member);}
    }
    public void remove(Member member) {
        if (isRemote()) {remote_database.deleteMember(member);}
        _list.remove(member);
    }

    public void update(int id, Member member) {
        Member tmp = _list.stream().filter(p -> p.memberId ==id).findFirst().get();
        _list.set(_list.indexOf(tmp), member);
        if (isRemote()) {remote_database.updateMember(member);}
    }

    public List<Member> getAll() {
        return _list;
    }

    public Member getMemberById(int id) {
        return _list.stream().filter(p -> p.memberId ==id).findAny().orElse(null);
    }

    public Member getMemberByEmail(String email) {
        return _list.stream().filter(p -> p.email.equals(email)).findFirst().get();
    }

    public Member getMemberByPhone(String phone) {
        return _list.stream().filter(p -> p.phone.equals(phone)).findFirst().get();
    }

    public Member getMemberByName(String name) {
        return _list.stream().filter(p -> p.fullName.equals(name)).findFirst().get();
    }

    public Member getMemberByAny(String search) {
        return _list.stream().filter(p -> p.toString().equals(search)).findFirst().get();
    }

    public Stream<Member> searchAll(String search) {
        return _list.stream().filter(p -> p.toString().toLowerCase().contains(search.toLowerCase()));
    }

    public List<Member> searchAllToList(String search) {
        return _list.stream().filter(p -> p.toString().toLowerCase().contains(search.toLowerCase())).toList();
    }
}