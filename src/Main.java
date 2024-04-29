import br.com.allanflm.screenmatch.model.Movie;
import br.com.allanflm.screenmatch.model.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Blade runner", 2017);
        movie.setFilmDurationInMinutes(180);
        movie.filmReview(10);

        var movie2 = new Movie("Sev7n", 1999);
        movie2.setFilmDurationInMinutes(180);
        movie2.filmReview(9.6);

        Series series = new Series("Supernatural", 2005);

        ArrayList<Movie> listMovies = new ArrayList<>();
        listMovies.add(movie);
        listMovies.add(movie2);
        System.out.println("List Size -> " + listMovies.size());
        System.out.println("Fist movie in list -> " + listMovies.get(0).toString());
        System.out.println(listMovies);

    }
}
