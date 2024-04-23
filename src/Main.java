import br.com.allanflm.screenmatch.model.Movie;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("Blade runner 2049");
        myMovie.setReleaseYear(2017);
        myMovie.setFilmDurationInMinutes(180);

        myMovie.filmTechnicalSheet();
        myMovie.filmReview(10);
        myMovie.filmReview(8);
        myMovie.filmReview(7);
        System.out.println("Total Assessment: " + myMovie.getTotalAssessment());
        System.out.println("return the evaluation: " + myMovie.returnTheEvaluation());

    }
}
