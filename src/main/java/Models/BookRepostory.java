package Models;

import DAO.JibraryDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookRepostory {
    private List<Book> _list = new ArrayList<>();
    private JibraryDatabase remote_database = null;

    public BookRepostory() {
        //local only mode
    }

    public BookRepostory(boolean isRemote) {
        if (isRemote) {
            remote_database = new JibraryDatabase();
            _list = remote_database.loadBookList();
        }
    }

    public boolean isRemote() {
        return (remote_database!=null);
    }

    public int getLastBookId() {
        //return Collections.max(_data, Comparator.comparing(Person::getPersonId)).getPersonId();
        int max_id = 0;
        for (int i = 0; i< _list.size(); i++) {
            if (_list.get(i).bookId >max_id) {
                max_id = _list.get(i).bookId;
            }
        }
        return max_id;
    }

    public void syncRemote() {
        if (isRemote()) {
            _list = remote_database.loadBookList();
        }
    }

    public void add(Book book) {
        if (book.bookId<1) {book.bookId = getLastBookId()+1;}
        _list.add(book);
        if (isRemote()) {remote_database.addBook(book);}
    }

    public void remove(Book book) {
        if (isRemote()) {remote_database.deleteBook(book);}
        _list.remove(book);
    }

    public void update(int id, Book book) {
        Book tmp = getBookById(id);
        _list.set(_list.indexOf(tmp), book);
        if (isRemote()) {remote_database.updateBook(book);}
    }

    public Book getBookById(int id) {
        return _list.stream().filter(book -> book.bookId == id).findFirst().orElse(null);
    }

    public List<Book> getAll() {
        return _list;
    }
    public List<Book> searchAllToList(String search) {
        //return _list.stream().filter(b -> b.toString().toLowerCase().contains(search.toLowerCase())).toList();
        List<Book> result = new ArrayList<>();
        for (Book b : _list) {
            if (b.title.contains(search)) {
                result.add(b);
            }
            }
        return result;
        }


    }


