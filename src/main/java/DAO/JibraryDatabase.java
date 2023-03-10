package DAO;

import Models.Book;
import Models.Person;

import java.util.List;

public class JibraryDatabase {
    private MongoDBClient mongo = new MongoDBClient();


    /***************************************
     *      Person Class methods
     ****************************************/
    public List<Person> loadPersonList() {
        return mongo.loadList("Person", Person.class);
    }

    public void addPerson(Person person) {
        if (person!= null) {
            mongo.insert(person, Person.class, "Person");
        }
    }

    public void updatePerson(Person person) {
        if (person!= null) {
            mongo.update(person, Person.class, "Person", "personId", person.personId);
        }
    }

    public void deletePerson(Person person) {
        if (person!= null) {
            mongo.delete(person, Person.class, "Person", "personId", person.personId);
        }
    }

    /***************************************
     *      Book Class methods
     ****************************************/

    public List<Book> loadBookList() {
        return mongo.loadList("Book", Book.class);
    }

    public  void addBook(Book book) {
        if (book!= null) {
            mongo.insert(book, Book.class, "Book");
        }
    }

    public void updateBook(Book book) {
        if (book!= null) {
            mongo.update(book, Book.class, "Book", "bookId", book.bookId);
        }
    }

    public void deleteBook(Book book) {
        if (book!= null) {
            mongo.delete(book, Book.class, "Book", "bookId", book.bookId);
        }
    }
}
