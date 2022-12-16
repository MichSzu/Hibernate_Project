package Model;

import javax.persistence.*;

@Entity
@Table(name = "stadium")
public class Stadium {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @OneToOne(mappedBy = "stadium")
    private Club club;

    public Club getClub() { return club; }

    public void setClub(Club club) { this.club = club; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString(){
        return "Stadium{" +
                "name = " + name +
                ", height = " + height +
                ", capacity = " + capacity +
                '}';
    }
}
