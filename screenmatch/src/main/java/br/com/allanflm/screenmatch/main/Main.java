package br.com.allanflm.screenmatch.main;

import br.com.allanflm.screenmatch.model.DataEpisode;
import br.com.allanflm.screenmatch.model.DataSeason;
import br.com.allanflm.screenmatch.model.DataSeries;
import br.com.allanflm.screenmatch.service.ConsumptionAPI;
import br.com.allanflm.screenmatch.service.ConvertsData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=b97536d8";
    private Scanner input = new Scanner(System.in);
    private ConsumptionAPI consumo = new ConsumptionAPI();
    private ConvertsData conversor = new ConvertsData();

    public void displaysMenu() {
        System.out.print("Enter the name of the series to search: ");
        var seriesName = input.nextLine();
        var json = consumo.getData(ENDERECO + seriesName.replace(" ", "+") + API_KEY);
        ConvertsData convertsData = new ConvertsData();
        DataSeries dados = convertsData.getData(json, DataSeries.class);
        System.out.println(dados);


        List<DataSeason> seasonArrayList = new ArrayList<>();

        for (int i = 1; i <= dados.seasons(); i++) {
            json = consumo.getData(ENDERECO + seriesName.replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dataSeason = convertsData.getData(json, DataSeason.class);
            seasonArrayList.add(dataSeason);

        }

        seasonArrayList.forEach(s -> s.episodios().forEach(e -> System.out.println(e.titulo())));


        List<DataEpisode> dataEpisodes = seasonArrayList.stream()
                .flatMap(s -> s.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 Episodios:");
        dataEpisodes.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DataEpisode::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

    }
}
