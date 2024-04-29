import br.com.allanflm.screenmatch.model.Movie;
import br.com.allanflm.screenmatch.model.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Blade runner");
        movie.setReleaseYear(2017);
        movie.setFilmDurationInMinutes(180);
        movie.filmReview(10);

        var movie2 = new Movie();
        movie2.setName("Sev7n");
        movie2.setReleaseYear(1999);
        movie2.setFilmDurationInMinutes(180);
        movie2.filmReview(9.6);

        Series series = new Series();
        series.setName("Supernatural");
        series.setReleaseYear(2005);

        ArrayList<Movie> listMovies = new ArrayList<>();
        listMovies.add(movie);
        listMovies.add(movie2);
        System.out.println("List Size -> " + listMovies.size());
        System.out.println("Fist movie in list -> " + listMovies.get(0).toString());
        System.out.println(listMovies);

    }
}
