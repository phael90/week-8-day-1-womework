package models;

import javax.persistence.*;

@Entity
@Table(name = "drums")
public class Drums {

    private int id;
    private String name;

    public Drums(String name) { this.name = name; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
