package k24.op1.dogbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;

@SpringBootApplication
public class DogbackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository) {
		return (args) -> {

		productRepository.save(new Product("Ulkoilutakki", "Ulkoiluun soveltuva takki", "Varuste", "Multicolor", "Onesize", 50.00, "Rukka"));
		};
	}

}