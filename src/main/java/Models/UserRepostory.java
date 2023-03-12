package Models;

import DAO.JibraryDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserRepostory {

    private List<User> _list = new ArrayList<User>();
    private JibraryDatabase remote_database = null;

    public UserRepostory() {
        // local only mode...
    }

    public UserRepostory(boolean isRemote) {
        if (isRemote) {
            remote_database = new JibraryDatabase();
            _list = remote_database.loadUserList();
        }
    }

    public boolean isRemote() {
        return (remote_database!=null);
    }

    public int getLastUserId() {
        int max_id = 0;
        for (int i = 0; i < _list.size(); i++) {
            if (_list.get(i).userId > max_id) {
                max_id = _list.get(i).userId;
            }
        }
        return max_id;
    }

    public void syncRemote() {
        if (isRemote()) {
            _list = remote_database.loadUserList();
        }
    }

    public void add(User u) {
        if (u.userId<1) {u.userId=getLastUserId()+1;}

        _list.add(u);
        if (isRemote()) {remote_database.addUser(u);}
    }

    public void remove(User u) {
        if (u!=null) {
            _list.remove(u);
            if (isRemote()) {remote_database.deleteUser(u);}
        }
    }

    public void update(int id, User u) {
        if (u!=null) {
            User tmp = getUserById(id);
            _list.set(_list.indexOf(tmp), u);
            if (isRemote()) {remote_database.updateUser(u);}
        }
    }

    public User getUserById(int id) {
        return _list.stream().filter(u->u.userId==id).findFirst().orElse(null);
    }

    public User getUserByEmail(String eMail) {
        return _list.stream().filter(u->u.email.equals(eMail)).findFirst().orElse(null);
    }

    public User getUserByUserName(String UName) {
        return _list.stream().filter(u->u.fullName.equals(UName)).findFirst().orElse(null);
    }

    public List<User> searchAllToList(String keyword) {
        return _list.stream().filter(u->u.toString().toLowerCase().contains(keyword.toLowerCase())).toList();
    }

}
