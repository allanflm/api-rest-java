import br.com.allanflm.screenmatch.exceptions.YearConversationErrorException;
import br.com.allanflm.screenmatch.model.OMDBTitle;
import br.com.allanflm.screenmatch.model.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        var searchedMovie = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!searchedMovie.equalsIgnoreCase("exit")) {

            System.out.print("Enter the name of the movie you want: ");
            searchedMovie = input.nextLine();

            if (searchedMovie.equalsIgnoreCase("exit")) {
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + searchedMovie.replace(" ", "+") + "&apikey=b97536d8";
            System.out.println(address);

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());

                String json = response.body();
                System.out.println(json);

                OMDBTitle omdbTitle = gson.fromJson(json, OMDBTitle.class);
                System.out.println(omdbTitle);

                Title myTitle = new Title(omdbTitle);
                System.out.println("Title already converted.");
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("[ERRO] -> " + e.getMessage());
            } catch (YearConversationErrorException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titles);

        FileWriter text = new FileWriter("movies.json");
        text.write(gson.toJson(titles));
        text.close();
        System.out.println("Finished!");
    }

}
