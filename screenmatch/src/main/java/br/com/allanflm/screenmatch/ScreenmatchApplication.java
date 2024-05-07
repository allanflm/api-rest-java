package br.com.allanflm.screenmatch;

import br.com.allanflm.screenmatch.service.ConsumptionAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}
}
