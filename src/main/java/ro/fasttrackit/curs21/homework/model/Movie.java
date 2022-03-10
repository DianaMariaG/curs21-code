package ro.fasttrackit.curs21.homework.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int year;

    @OneToOne
    private MovieRating movieRating;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    private Studio studio;

    @ManyToMany
    private List<Actor> actors;

    public Movie(){
    }

    public Movie(String name, int year) {
        this(null, name, year);
    }

    public Movie(MovieRating movieRating, String name, int year) {
        this(movieRating, List.of(), name, year);
    }

    public Movie(MovieRating movieRating, List<Review> reviews, String name, int year) {
        this(movieRating, reviews, null, name, year);
    }

    public Movie(MovieRating movieRating, List<Review> reviews, Studio studio, String name, int year){
        this(movieRating, reviews, studio, List.of(), name, year);
    }

    public Movie(MovieRating movieRating, List<Review> reviews, Studio studio, List<Actor> actors, String name, int year) {
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studio = studio;
        this.actors = actors;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", movieRating=" + movieRating +
                ", reviews=" + reviews +
                ", studio=" + studio +
                ", actors=" + actors +
                '}';
    }
}
