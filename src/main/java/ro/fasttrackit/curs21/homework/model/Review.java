package ro.fasttrackit.curs21.homework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String reviewer;

    public Review(){
    }

    public Review(String name, String reviewer) {
        this.name = name;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReviewer() {
        return reviewer;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
