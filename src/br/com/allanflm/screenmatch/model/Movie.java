package br.com.allanflm.screenmatch.model;

import br.com.allanflm.screenmatch.calculation.Sortable;

public class Movie extends Title implements Sortable {

    private String director;

    public Movie(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) returnTheEvaluation() / 2;
    }

    @Override
    public String toString() {
        return "Movie: " + this.getName() + " (" + getReleaseYear() + ")";
    }
}
