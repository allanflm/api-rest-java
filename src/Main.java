import br.com.allanflm.screenmatch.model.Movie;
import br.com.allanflm.screenmatch.model.Series;
import br.com.allanflm.screenmatch.model.Title;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Blade runner", 2017);
        movie.setFilmDurationInMinutes(180);
        movie.filmReview(10);

        var movie2 = new Movie("Sev7n", 1999);
        movie2.setFilmDurationInMinutes(180);
        movie2.filmReview(9.6);

        var movie3 = new Movie("Avatar", 2022);
        movie3.setFilmDurationInMinutes(180);
        movie3.filmReview(7.9);

        Series series = new Series("Supernatural", 2005);

        ArrayList<Title> list = new ArrayList<>();
        list.add(movie);
        list.add(movie2);
        list.add(movie3);
        list.add(series);
        for (Title item : list) {
            System.out.println("Name: " + item.getName());
            if (item instanceof Movie film && film.getClassification() > 2) {
                System.out.println("Classification: " + film.getClassification());
            }
        }

        System.out.println("--------------");
        System.out.println(list);
        System.out.println("--------------");
        System.out.println("Sorting by name:");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("--------------");
        System.out.println("Sorted by year of release:");
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(list);
        System.out.println("--------------");


    }
}
