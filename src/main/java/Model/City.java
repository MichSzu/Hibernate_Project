package Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "code", unique = true, nullable = false)
    private int code;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_city_stadium", referencedColumnName = "name")
    private Set<Stadium> stadiums;

    public Set<Stadium> getStadiums() { return stadiums; }

    public void setStadiums(Set<Stadium> stadiums) { this.stadiums = stadiums; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    @Override
    public String toString(){
        return "City{" +
                "name = " + name +
                ", country = " + country +
                ", code = " + code +
                '}';
    }
}
