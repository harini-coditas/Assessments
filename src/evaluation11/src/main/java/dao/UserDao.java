package dao;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

public class UserDao {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
    public static void create(User user){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }
    public static void update(int uid) throws IOException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, uid);
        System.out.println("Enter balance to be updated");
        int bal = Integer.parseInt(br.readLine());
        user.setBalance(bal);
        em.merge(user);

        em.getTransaction().commit();
        em.close();
    }
    public static void delete(int did){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, did);
        em.remove(user);

        em.getTransaction().commit();
        em.close();
    }
    public static void selectAll(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<User> query = em.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        for(User u : list){
            System.out.println(u);
        }

        em.getTransaction().commit();
        em.close();
    }
    public static void selectById(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = :uid", User.class);
        query.setParameter("uid", id);
        List<User> list = query.getResultList();
        for(User u : list){
            System.out.println(u);
        }

        em.getTransaction().commit();
        em.close();
    }
}
