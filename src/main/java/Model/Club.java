package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "league", nullable = false)
    private String league;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "fk_stadium_club")
    private Stadium stadium;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_club_footballer", referencedColumnName = "name")
    private Set<Footballer> footballers;

    public Set<Footballer> getFootballers() { return footballers; }

    public void setFootballers(Set<Footballer> footballers) { this.footballers = footballers; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Stadium getStadium() { return stadium; }

    public void setStadium(Stadium stadium) { this.stadium = stadium; }

    public String getLeague() { return league; }

    public void setLeague(String league) { this.league = league; }

    @Override
    public String toString(){
        return "Club{" +
                "name = " + name +
                ", league = " + league +
                ", color = " + color +
                ", stadium = " + stadium +
                ", footballers = " + footballers +
                '}';
    }

}
