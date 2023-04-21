package org.example;

import javafx.scene.control.TableRow;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.AbstractUUIDGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Author author = new Author();
        author.setAuthorId(1);
        author.setAuthorName("Aarti");

        Book book = new Book();
        book.setBookId(1);
        book.setBookName("Harry Potter");
        book.setBookPrice(500);
        book.setAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setPublisherId(1);
        publisher.setPublisherName("Nirali");
        publisher.setPublishedDate((java.sql.Date) new Date());
        publisher.setBook(book);

        Book book1 = new Book();
        book1.setBookId(2);
        book1.setBookName("Harry Potter 2");
        book1.setBookPrice(800);
        book1.setAuthor(author);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherId(2);
        publisher1.setPublisherName("Nirali");
        publisher1.setPublishedDate((java.sql.Date) new Date());
        publisher1.setBook(book1);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        bookList.add(book1);
        author.setBookList(bookList);

        session.save(author);
        session.save(book);
        session.save(book1);
        session.save(publisher);
        session.save(publisher1);

        transaction.commit();

        session.close();


    }
}
