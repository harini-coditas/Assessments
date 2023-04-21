package org.example;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Date;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws IOException, ParseException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Book bookMain = new Book();
        Author authorMain = new Author();
        Publisher publisherMain = new Publisher();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("--------------------------");
        System.out.println("Enter : ");
        System.out.println("1 to Create Author");
        System.out.println("2 to Select Author");
        System.out.println("3 to Delete Author");
        System.out.println("4 to Update Author");
        System.out.println("5 to date query");
        System.out.println("6 to Nirali and >500 query");
        System.out.println("7 to author name  A & I query");
        System.out.println("8 Create Book");
        System.out.println("9 Select Book");
        System.out.println("10 Create Publisher *");
        System.out.println("11 select Publisher *");
        System.out.println("12 delete Book");
        System.out.println("13 delete Publisher");
        System.out.println("0 to EXIT");
        System.out.println("--------------------------");


        while(true) {

            System.out.println("Enter choice");
            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();

                    Author author = new Author();

                    System.out.println("enter author id");
                    int aId = Integer.parseInt(br.readLine());
                    author.setAuthorId(aId);

                    System.out.println("Enter author name");
                    String aName = br.readLine();
                    author.setAuthorName(aName);

                    session.save(author);
                    transaction.commit();
                    session.close();


                    break;
                case 2:
                    Session session1 = sessionFactory.openSession();
                    List<Author> authors = session1.createQuery("SELECT a FROM Author a", Author.class).getResultList();
                    for(Author author1: authors){
                        System.out.println(author1.getAuthorId()+","+author1.getAuthorName());
                       // System.out.println(author1.getAuthorName());
                    }
                    session1.close();
                    break;
                case 3:
                    Session session2 = sessionFactory.openSession();
                    Transaction transaction2 = session2.beginTransaction();

                    System.out.println("Enter id to be deleted");
                    int aId2 = Integer.parseInt(br.readLine());

                    String sql = "DELETE FROM author WHERE authorId = :id";
                    NativeQuery<Author> query = session2.createNativeQuery(sql, Author.class);
                    query.setParameter("id", aId2);
                    int result = query.executeUpdate();

                    transaction2.commit();

                    break;
                case 4:
                    Session session3 = sessionFactory.openSession();
                    Transaction transaction3 = session3.beginTransaction();

                    System.out.println("Enter id to be updated");
                    int aId3 = Integer.parseInt(br.readLine());
                    System.out.println("Enter name to update");
                    String aName2 = br.readLine();

                    String sql1 = "UPDATE author SET authorName = :aName WHERE authorId = :aId";
                    NativeQuery<Author> query1 = session3.createNativeQuery(sql1, Author.class);
                    query1.setParameter("aName", aName2);
                    query1.setParameter("aId", aId3);

                    int rowsAffected = query1.executeUpdate();
                    System.out.println("Rows affected: " + rowsAffected);

                    Author author3 = session3.get(Author.class, aId3);
                    author3.setAuthorName(aName2);
                    session3.update(author3);

                    transaction3.commit();
                    session3.close();

                    break;
                case 8:
                    Session session4 = sessionFactory.openSession();
                    Transaction transaction4 = session4.beginTransaction();

                    Book book = new Book();

                    System.out.println("enter book id");
                    int bId = Integer.parseInt(br.readLine());
                    book.setBookId(bId);

                    System.out.println("Enter book name");
                    String bName = br.readLine();
                    book.setBookName(bName);

                    System.out.println("Enter book price");
                    int bPrice = Integer.parseInt(br.readLine());
                    book.setBookPrice(bPrice);

                    System.out.println("Enter book author");
                    Author bAuthor = new Author();
                    System.out.println("Enter book author Id");
                    int bAuthorId = Integer.parseInt(br.readLine());
                    bAuthor.setAuthorId(bAuthorId);

                    System.out.println("Enter book author Name");
                    String bAuthorName = br.readLine();
                    bAuthor.setAuthorName(bAuthorName);

                    session4.save(book);
                    //session4.save(authorMain);
                    session4.save(bAuthor);
                   // session4.save(bAuthorId);
                   // session4.save(bAuthorName);

                    transaction4.commit();
                    session4.close();
                    break;
                case 9:
                    Session session9 = sessionFactory.openSession();
                    List<Book> books9 = session9.createQuery("SELECT b FROM Book b", Book.class).getResultList();
                    for(Book book9: books9){
                        System.out.println(book9);
                        //System.out.println(book9.getBookId()+","+book9.getBookPrice()+","+book9.getAuthor()+","+book9.getAuthor().getAuthorName());
                    }
                    session9.close();
                    break;
                case 10:
                    Session session10 = sessionFactory.openSession();
                    Transaction transaction10 = session10.beginTransaction();

                    Publisher publisher = new Publisher();

                    System.out.println("enter publisher id");
                    int pId = Integer.parseInt(br.readLine());
                    publisher.setPublisherId(pId);

                    System.out.println("Enter pub name");
                    String pName = br.readLine();
                    publisher.setPublisherName(pName);

                    System.out.println("Enter publishedDate");
                    java.util.Date utilDate = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date pDate = (Date) dateFormat.parse(br.readLine());
                    //Date pDate = (br.readLine());
                    publisher.setPublishedDate(pDate);

                 //   System.out.println("Enter book Id");
//                    Book pBook = new Book();
//                    //Integer.parseInt(br.readLine());
//                    Publisher.setBook(pBook);
//
//                    session10.save(pBook);

                    transaction10.commit();
                    session10.close();
                    break;
                case 11:
                    Session session11 = sessionFactory.openSession();
                    List<Publisher> publishers11 = session11.createQuery("SELECT p FROM Publishers p", Publisher.class).getResultList();
                    for(Publisher p11: publishers11){
                        System.out.println(p11);
                        //System.out.println(book9.getBookId()+","+book9.getBookPrice()+","+book9.getAuthor()+","+book9.getAuthor().getAuthorName());
                    }
                    session11.close();


                    break;
                case 12:
                    Session session12 = sessionFactory.openSession();
                    Transaction transaction12 = session12.beginTransaction();

                    System.out.println("Enter id to be deleted");
                    int bId12 = Integer.parseInt(br.readLine());

                    String sql12 = "DELETE FROM book WHERE bookId = :id";
                    NativeQuery<Book> query12 = session12.createNativeQuery(sql12, Book.class);
                    query12.setParameter("id", bId12);
                    int result12 = query12.executeUpdate();

                    transaction12.commit();

                    break;
                case 13:
                    Session session13 = sessionFactory.openSession();
                    Transaction transaction13 = session13.beginTransaction();

                    System.out.println("Enter id to be deleted");
                    int pId13 = Integer.parseInt(br.readLine());

                    String sql13 = "DELETE FROM publisher WHERE publisherId = :id";
                    NativeQuery<Publisher> query13 = session13.createNativeQuery(sql13, Publisher.class);
                    query13.setParameter("id", pId13);
                    int result13 = query13.executeUpdate();

                    transaction13.commit();

                    break;

                case 5:

                    Session session5 = sessionFactory.openSession();
                    Transaction transaction5 = session5.beginTransaction();

                    String hql5 = "SELECT a FROM Author a JOIN a.bookList b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND p.publishedDate >= '2021-01-01'";
                  //  String hql15 = "SELECT p.publishedDate FROM Publisher p JOIN a.bookList b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND p.publishedDate >= '2021-01-01'";

                    TypedQuery<Author> query5 = session5.createQuery(hql5, Author.class);
                    List<Author> authors5 = query5.getResultList();

                    for (Author author5 : authors5) {
                        System.out.println(author5.getAuthorId()+","+author5.getAuthorName());
                       // System.out.println(author5.getAuthorName());
                        session5.save(author5);
                    }

                    session5.getTransaction().commit();
                    session5.close();

                    break;
                case 6:
                    Session session6 = sessionFactory.openSession();
                    Transaction transaction6 = null;
                        try {
                            transaction6 = session6.beginTransaction();

                            String hql = "SELECT b FROM Book b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND b.bookPrice >= 600";
                            Query query6 = session6.createQuery(hql);

                            List results = query6.getResultList();
                            for (Object result6 : results) {
                                if (result6 instanceof Book) {
                                    Book book6 = (Book) result6;
                                  //  System.out.println(book6.getTitle());
                                    System.out.println(book6.getBookId());
                                    System.out.println(book6.getBookPrice());
                                    System.out.println(book6.getBookName());
                                    System.out.println(book6.getAuthor().getAuthorName()); // example of printing the title of each book
                                }
                            }

                            transaction6.commit();
                        } catch (Exception e) {
                            if (transaction6 != null) transaction6.rollback();
                            e.printStackTrace();
                        } finally {
                            session6.close();
                        }

                    break;
                case 7:
                    Session session7 = sessionFactory.openSession();
                    Transaction transaction7 = session7.beginTransaction();

                    //String hql7 = "FROM Book b JOIN b.publisher p WHERE p.publisherName = 'Nirali' AND b.bookPrice >= 500";
                    String hql7 = "SELECT b FROM Book b JOIN b.author a WHERE a.authorName LIKE 'A%i'";
                    List<Book> books7 = session7.createQuery(hql7, Book.class).getResultList();
                    for (Book value : books7) {
                        System.out.println(value);
//                        System.out.println(value.getAuthorName());
                    }
                    //session7.save(books7);
                    transaction7.commit();
                    session7.close();

                    break;




                case 0:
                    System.out.println("Exit...");
                    System.exit(0);
                    break;


            }
        }
    }
}
