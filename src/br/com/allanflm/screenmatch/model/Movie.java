package br.com.allanflm.screenmatch.model;

public class Movie {
    private String name;
    private int releaseYear;
    private boolean includedPlan;
    private double sumOfRatings;
    private int totalAssessment;
    private double filmDurationInMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFilmDurationInMinutes() {
        return filmDurationInMinutes;
    }

    public void setFilmDurationInMinutes(double filmDurationInMinutes) {
        this.filmDurationInMinutes = filmDurationInMinutes;
    }

    public void setTotalAssessment(int totalAssessment) {
        this.totalAssessment = totalAssessment;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public boolean isIncludedPlan() {
        return includedPlan;
    }

    public void setIncludedPlan(boolean includedPlan) {
        this.includedPlan = includedPlan;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getTotalAssessment() {
        return totalAssessment;
    }

    public void filmTechnicalSheet() {
        System.out.println("Name: " + getName());
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Film Duration In Minutes: " + getFilmDurationInMinutes() + "min.");
    }

    public void filmReview(double note) {
        sumOfRatings += note;
        totalAssessment++;
    }

    public double returnTheEvaluation() {
        return sumOfRatings / totalAssessment;
    }

}
