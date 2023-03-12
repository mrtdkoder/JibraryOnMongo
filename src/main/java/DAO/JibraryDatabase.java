package DAO;

import Models.Book;
import Models.Member;

import java.util.List;

public class JibraryDatabase {
    private MongoDBClient mongo = new MongoDBClient();


    /***************************************
     *      Member Class methods
     ****************************************/
    public List<Member> loadPersonList() {
        return mongo.loadList("Member", Member.class);
    }

    public void addMember(Member member) {
        if (member != null) {
            mongo.insert(member, Member.class, "Member");
        }
    }

    public void updateMember(Member member) {
        if (member != null) {
            mongo.update(member, Member.class, "Member", "memberId", member.memberId);
        }
    }

    public void deleteMember(Member member) {
        if (member != null) {
            mongo.delete(member, Member.class, "Member", "memberId", member.memberId);
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
