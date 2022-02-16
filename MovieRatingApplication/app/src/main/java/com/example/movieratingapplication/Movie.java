package com.example.movieratingapplication;

public class Movie {
    private String name;
    private String year;
    private String length;
    private String director;
    private String rating;
    private String actors;
    private String description;

    public String getActors() {
        return actors;
    }

    public String getDescription() {
        return description;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
