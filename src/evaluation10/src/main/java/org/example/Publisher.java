package org.example;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;
    private String publisherName;
    @Temporal(TemporalType.DATE)
    private Date publishedDate;
    @OneToOne
    private Book book;

    public Publisher(int publisherId, String publisherName, Date publishedDate, Book book) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publishedDate = publishedDate;
        this.book = book;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Publisher() {
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
