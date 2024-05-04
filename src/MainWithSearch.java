import br.com.allanflm.screenmatch.exceptions.YearConversationErrorException;
import br.com.allanflm.screenmatch.model.OMDBTitle;
import br.com.allanflm.screenmatch.model.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the movie you want: ");
        var searchedMovie = input.nextLine();
        String address = "https://www.omdbapi.com/?t=" + searchedMovie + "&apikey=b97536d8";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            // Title title = gson.fromJson(json, Title.class);

            OMDBTitle omdbTitle = gson.fromJson(json, OMDBTitle.class);
            System.out.println(omdbTitle);

            Title myTitle = new Title(omdbTitle);
            System.out.println("Titulo ja convertido");
            System.out.println(myTitle);
        } catch (NumberFormatException e) {
            System.out.println("[ERRO] -> " + e.getMessage());
        }catch (YearConversationErrorException e){
            System.out.println(e.getMessage());
        }

    }
}
