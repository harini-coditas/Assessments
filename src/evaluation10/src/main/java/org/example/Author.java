package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Author(int authorId, String authorName, List<Book> bookList) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.bookList = bookList;
    }

    public Author() {
    }

    public void getAuthorName(Class<Author> authorClass, int aId1) {
    }
}
