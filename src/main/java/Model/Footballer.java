package Model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "footballer")
public class Footballer implements Serializable {
    //private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "year_of_birth")
    private String year_of_birth;

    @OneToOne
    @JoinColumn(name = "fk_footballer_doctor")
    private Doctor doctor;

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getYear_of_birth() { return year_of_birth; }

    public void setYear_of_birth(String year_of_birth) { this.year_of_birth = year_of_birth; }

    public long getAge(){
        int year = Integer.parseInt(getYear_of_birth());
        LocalDate birth = LocalDate.of(year, Month.JANUARY, 3);
        LocalDate now = LocalDate.now();
        long days = ChronoUnit.YEARS.between(birth,now);
        return days;
    }

    @Override
    public String toString(){
        return "Footballer{" +
                "id = " + id +
                ", firstname = " + firstname +
                ", lastname = " + lastname +
                ", year_of_birth = " + year_of_birth +
                ", doctor = " + doctor +
                '}';
    }

}
