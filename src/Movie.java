public class Movie {
    String name;
    int releaseYear;
    boolean includedPlan;
    double sumOfRatings;
    int totalAssessment;
    double filmDurationInMinutes;


    void filmTechnicalSheet() {
        System.out.println("Name: " + name);
        System.out.println("Release Year: " + releaseYear);
    }

    void filmReview(double note) {
        sumOfRatings += note;
        totalAssessment++;
    }

    double returnTheEvaluation() {
        return sumOfRatings / totalAssessment;
    }

}
