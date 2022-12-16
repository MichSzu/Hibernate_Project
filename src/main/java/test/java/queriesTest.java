package test.java;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.test.reflection.java.Foo;
import org.hibernate.annotations.common.test.reflection.java.TestAnnotation;
import org.junit.Assert;
import org.junit.Test;
import Model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class queriesTest {

    @Test
    public void testAllFootballers(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        List<Footballer> footballerList = new ArrayList<>();
        footballerList = new Queries(session).getAllFootballers();

        Assert.assertFalse(footballerList.isEmpty());
    }

    @Test
    public void testAllDoctors(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        List<Doctor> doctorList = new ArrayList<>();
        doctorList = new Queries(session).getAllDoctors();

        Assert.assertFalse(doctorList.isEmpty());
    }

    @Test
    public void testGetFootbalersByName(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        String name = "Leo";
        List<Footballer> footballerListWithNAme = new ArrayList<>();
        footballerListWithNAme = new Queries(session).getFootballersByName(name);

        List<Footballer> footballersList = new ArrayList<>();
        footballersList = new Queries(session).getAllFootballers();

        int ammount = 0;
        for(Footballer footballer : footballersList){
            if(footballer.getFirstname().equals("Leo")){
                ammount = ammount + 1;
            }
        }
        Assert.assertTrue(footballerListWithNAme.size() == ammount);
    }

    @Test
    public void testGetDoctorsHigherThan(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        int id = 3;
        List<Doctor> doctorsWithIds = new ArrayList<>();
        doctorsWithIds = new Queries(session).getDoctorsHigherThan(id);

        List<Doctor> doctorsList = new ArrayList<>();
        doctorsList = new Queries(session).getAllDoctors();

        int ammount = 0;
        for(Doctor doctor : doctorsList){
            if(doctor.getId() > id){
                ammount = ammount + 1;
            }
        }
        Assert.assertTrue(doctorsWithIds.size() == ammount);
    }

    @Test
    public void testGetAllFootballerPages(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();

        //Footballer objects = 8
        //pageSize = 3

        List<Footballer> footballerList2 = new ArrayList<>();
        footballerList2 = new Queries(session).getAllFootballerPages(2);

        List<Footballer> footballerList3 = new ArrayList<>();
        footballerList3 = new Queries(session).getAllFootballerPages(3);

        Assert.assertTrue(footballerList2.size() > footballerList3.size());
    }
}
