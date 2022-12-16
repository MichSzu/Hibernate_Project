package Model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.test.reflection.java.Foo;

import javax.persistence.*;
import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;


public class ProductModel{
    public static  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

    public static void main(String[] args){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        List<Club> footballers = new ArrayList<>();
        footballers = new Queries(session).getAllClubs();
        for(Club footballer : footballers){
            System.out.println(footballer.toString());
        }

        tx.commit();
        session.close();
    }

    public static void getAges(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        List<Footballer> footballers = new ArrayList<>();
        footballers = new Queries(session).getAllFootballers();

        for(Footballer footballer : footballers){
            System.out.println(footballer.getFirstname() + " " + footballer.getLastname() + " is " + footballer.getAge() + " years old");
        }
        tx.commit();
        session.close();
    }
}


