package br.com.allanflm.screenmatch.main;

import br.com.allanflm.screenmatch.model.DataSeason;
import br.com.allanflm.screenmatch.model.DataSeries;
import br.com.allanflm.screenmatch.service.ConsumptionAPI;
import br.com.allanflm.screenmatch.service.ConvertsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            json = consumo.getData(ENDERECO + seriesName.replace(" ", "+") +"&season=" + i + API_KEY);
            DataSeason dataSeason = convertsData.getData(json, DataSeason.class);
            seasonArrayList.add(dataSeason);

        }
        seasonArrayList.forEach(System.out::println);

        seasonArrayList.forEach(s -> s.episodios().forEach(e -> System.out.println(e.titulo())));
        seasonArrayList.forEach(System.out::println);

    }
}
