import br.com.allanflm.screenmatch.calculation.TimeCalculator;
import br.com.allanflm.screenmatch.model.Movie;
import br.com.allanflm.screenmatch.model.Series;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Blade runner");
        movie.setFilmDurationInMinutes(180);
        movie.filmTechnicalSheet();


        Series series = new Series();
        series.setName("Supernatural");
        series.setReleaseYear(2005);
        series.setFilmDurationInMinutes(300);
        series.filmTechnicalSheet();
        series.setSeasons(10);
        series.setEpisodesPerSeason(10);
        series.setMinutesPerEpisode(50);
        System.out.println("Marathon duration -> " + series.getDurationInMinutes() + " min.");


        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(movie);
        calculator.includes(series);
        calculator.getTotalTime();
    }
}
