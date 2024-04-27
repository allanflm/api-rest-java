import br.com.allanflm.screenmatch.calculation.RecommendationFilter;
import br.com.allanflm.screenmatch.calculation.TimeCalculator;
import br.com.allanflm.screenmatch.model.Episodes;
import br.com.allanflm.screenmatch.model.Movie;
import br.com.allanflm.screenmatch.model.Series;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Blade runner");
        movie.setFilmDurationInMinutes(180);

        movie.filmTechnicalSheet();
        movie.filmReview(10);
        movie.filmReview(9);
        movie.filmReview(8);
        System.out.println(movie.getTotalAssessment());


        Series series = new Series();
        series.setName("Supernatural");
        series.setReleaseYear(2005);
        series.setFilmDurationInMinutes(300);
        series.filmTechnicalSheet();
        series.setSeasons(10);
        series.setEpisodesPerSeason(10);
        series.setMinutesPerEpisode(50);
        System.out.println("Marathon duration -> " + series.getDurationInMinutes() + " min.");
        System.out.println(movie.returnTheEvaluation());


        TimeCalculator calculator = new TimeCalculator();
        calculator.includes(movie);
        calculator.includes(series);
        calculator.getTotalTime();

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(movie);

        Episodes episodes = new Episodes();
        episodes.setNumber(4);
        episodes.setSeries(series);
        episodes.setTotalViews(300);
        filter.filter(episodes);

    }
}
