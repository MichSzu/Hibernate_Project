package Model;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class Queries {

    Session session;
    public Queries(Session session) {this.session = session;}

    public List<City> getAllCities(){
        return session.createQuery("FROM City", City.class)
                .getResultList();
    }

    public List<Stadium> getAllStadiums(){
        return session.createQuery("FROM Stadium", Stadium.class)
                .getResultList();
    }

        public List<Club> getAllClubs(){
            return session.createQuery("FROM Club", Club.class)
                    .getResultList();
        }

        public List<Doctor> getAllDoctors(){
        return session.createQuery("FROM Doctor", Doctor.class)
                .getResultList();
    }

    public List<Footballer> getAllFootballers(){
        return session.createQuery("FROM Footballer",Footballer.class)
                .getResultList();
    }

    public List<Footballer> getFootballersByName(String firstname){
        return  session.createQuery(
                "SELECT c FROM Footballer c WHERE c.firstname LIKE :firstname", Footballer.class)
                .setParameter("firstname", "%" + firstname + "%").list();
    }

    public List<Doctor> getDoctorsHigherThan(int id){
        return session.createQuery(
                "SELECT c FROM Doctor c WHERE c.id > :id", Doctor.class)
                .setParameter("id", + id ).list();
    }

    public List<Footballer> getAllFootballerPages(int pagenr) {
        Query queryTotal = session.createQuery
                ("Select count(e) from Footballer e");
        long countResult = (long)queryTotal.getSingleResult();

        Query query = session.createQuery("Select e FROM Footballer e");

        int pageSize = 3;

        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

}
