package Models;

import DAO.JibraryDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersonRepostory {
    private List<Person> _list = new ArrayList<Person>();
    private JibraryDatabase remote_database=null;


    public PersonRepostory() {
        // local only mode
    }
    public PersonRepostory(boolean isRemote) {
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
            if (_list.get(i).getPersonId()>max_id) {
                max_id = _list.get(i).getPersonId();
            }
        }
        return max_id;
    }

    public void syncRemote() {
        if (isRemote()) {
            _list = remote_database.loadPersonList();
        }
    }

    public void add(Person person) {
        if (person.personId<1) {person.personId=getLastPersonId()+1;}
        _list.add(person);
        if (isRemote()) {remote_database.addPerson(person);}
    }
    public void remove(Person person) {
        if (isRemote()) {remote_database.deletePerson(person);}
        _list.remove(person);
    }

    public void update(int id, Person person) {
        Person tmp = _list.stream().filter(p -> p.personId==id).findFirst().get();
        _list.set(_list.indexOf(tmp), person);
        if (isRemote()) {remote_database.updatePerson(person);}
    }

    public List<Person> getAll() {
        return _list;
    }

    public Person getPersonById(int id) {
        return _list.stream().filter(p -> p.personId==id).findAny().orElse(null);
    }

    public Person getPersonByEmail(String email) {
        return _list.stream().filter(p -> p.email.equals(email)).findFirst().get();
    }

    public Person getPersonByPhone(String phone) {
        return _list.stream().filter(p -> p.phone.equals(phone)).findFirst().get();
    }

    public Person getPersonByName(String name) {
        return _list.stream().filter(p -> p.fullName.equals(name)).findFirst().get();
    }

    public Person getPersonByAny(String search) {
        return _list.stream().filter(p -> p.toString().equals(search)).findFirst().get();
    }

    public Stream<Person> searchAll(String search) {
        return _list.stream().filter(p -> p.toString().toLowerCase().contains(search.toLowerCase()));
    }

    public List<Person> searchAllToList(String search) {
        return _list.stream().filter(p -> p.toString().toLowerCase().contains(search.toLowerCase())).toList();
    }
}