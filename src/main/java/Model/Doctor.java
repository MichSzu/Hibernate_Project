package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "speciality")
    private String speciality;

    @OneToOne(mappedBy = "doctor")
    private Footballer footballer;

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getSpeciality() { return speciality; }

    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public Footballer getFootballer() { return footballer; }

    public void setFootballer(Footballer footballer) { this.footballer = footballer; }

    @Override
    public String toString() {
        return "Doctor{" +
                "id = " + id +
                ", firstname = " + firstname +
                ", lastname = " + lastname +
                ", speciality = " + speciality +
                '}';

    }
}
