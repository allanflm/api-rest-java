package br.com.allanflm.screenmatch;

import br.com.allanflm.screenmatch.model.DataEpisode;
import br.com.allanflm.screenmatch.model.DataSeason;
import br.com.allanflm.screenmatch.model.DataSeries;
import br.com.allanflm.screenmatch.service.ConsumptionAPI;
import br.com.allanflm.screenmatch.service.ConvertsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var api = new ConsumptionAPI();
        var json = api.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=b97536d8");
        System.out.println(json);

        ConvertsData convert = new ConvertsData();
        DataSeries data = convert.getData(json, DataSeries.class);
        System.out.println(data);


        json = api.getData("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=b97536d8");
        DataEpisode dataEpisode = convert.getData(json, DataEpisode.class);
        System.out.println(json);


        List<DataSeason> seasons = new ArrayList<>();

        for (int i = 1; i <= data.totalSeasons(); i++) {
            json = api.getData("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=b97536d8");
            DataSeason dataSeason = convert.getData(json, DataSeason.class);
            seasons.add(dataSeason);

        }
        seasons.forEach(System.out::println);
    }
}
