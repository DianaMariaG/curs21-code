package ro.fasttrackit.curs21.homework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int birthyear;

    public Actor() {
    }

    public Actor(String name, int birthyear) {
        this.name = name;
        this.birthyear = birthyear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthyear() {
        return birthyear;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthyear=" + birthyear +
                '}';
    }
}
