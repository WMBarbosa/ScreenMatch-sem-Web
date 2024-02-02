package br.com.alura.ScreenMatch2;

import br.com.alura.ScreenMatch2.model.DadosSerie;
import br.com.alura.ScreenMatch2.service.ConsumoApi;
import br.com.alura.ScreenMatch2.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatch2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=515bc55a");
		System.out.println(json);
//		json = consumoApi.obterDados("Https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
