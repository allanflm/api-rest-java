package br.com.allanflm.screenmatch.main;

import br.com.allanflm.screenmatch.model.DataEpisode;
import br.com.allanflm.screenmatch.model.DataSeason;
import br.com.allanflm.screenmatch.model.DataSeries;
import br.com.allanflm.screenmatch.model.Episode;
import br.com.allanflm.screenmatch.service.ConsumptionAPI;
import br.com.allanflm.screenmatch.service.ConvertsData;

import java.util.*;
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


        List<DataSeason> seasons = new ArrayList<>();

        for (int i = 1; i <= dados.seasons(); i++) {
            json = consumo.getData(ENDERECO + seriesName.replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dataSeason = convertsData.getData(json, DataSeason.class);
            seasons.add(dataSeason);

        }

        seasons.forEach(s -> s.episodios().forEach(e -> System.out.println(e.titulo())));


        List<DataEpisode> dataEpisodes = seasons.stream()
                .flatMap(s -> s.episodios().stream())
                .collect(Collectors.toList());


//        Top 10 Episodes
//        System.out.println("\nTop 10 Episodes:");
//        dataEpisodes.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primeiro filtro (N/A): " + e))
//                .sorted(Comparator.comparing(DataEpisode::avaliacao).reversed())
//                .peek(e -> System.out.println("Ordennação: " + e))
//                .limit(10)
//                .peek(e-> System.out.println("Limite: " + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Mapeamento: " + e))
//                .forEach(System.out::println);

        List<Episode> episodes = seasons.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episode(t.numero(), d))
                ).collect(Collectors.toList());

        episodes.forEach(System.out::println);

        //Enter a snippet of the episode title
//        System.out.println("Enter a snippet of the episode title: ");
//        var trecho = input.next();
//        Optional<Episode> episodeBuscado = episodes.stream()
//                .filter(e -> e.getTitle().toUpperCase().contains(trecho.toUpperCase()))
//                .findFirst();
//
//        if (episodeBuscado.isPresent()) {
//            System.out.println("Episodio encontrado!");
//            System.out.println("Temporada: " + episodeBuscado.get().getSeason());
//        } else {
//            System.out.println("Episodio nao encontrado!");
//        }


//        What year do you want to watch the episodes from?
//        System.out.println("What year do you want to watch the episodes from? ");
//        var year = input.nextInt();
//        input.nextLine();
//
//        LocalDate date = LocalDate.of(year, 1, 1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodes.stream()
//                .filter(e -> e.getReleaseDate() != null && e.getReleaseDate().isAfter(date))
//                .forEach(e -> System.out.println(
//                        "Season: " + e.getSeason() +
//                                "Episode: " + e.getTitle() +
//                                " Release date: " + e.getReleaseDate().format(formatter)
//                ));

        Map<Integer, Double> avaliacoesPorTemporada = episodes.stream()
                .filter(e -> e.getAssessment() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason,
                        Collectors.averagingDouble(Episode::getAssessment)));
        System.out.println(avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodes.stream()
                .filter(e -> e.getAssessment() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getAssessment));
        System.out.println("Média: " + est.getAverage());
        System.out.println("Melhor episodio: " + est.getMax());
        System.out.println("Pior episodio: " + est.getMin());
        System.out.println("Quantidade de episdios: " + est.getCount());
    }
}
