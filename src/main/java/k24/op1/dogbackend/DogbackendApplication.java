package k24.op1.dogbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;
import k24.op1.dogbackend.domain.Type;
import k24.op1.dogbackend.domain.TypeRepository;

@SpringBootApplication
public class DogbackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository, ManufacturerRepository manufacturerRepository, TypeRepository typeRepository) {
		return (args) -> {

			Manufacturer rukka = new Manufacturer("Rukka");
			manufacturerRepository.save(rukka);

			Manufacturer martta = new Manufacturer("Martta");
			manufacturerRepository.save(martta);

			Manufacturer pomppa = new Manufacturer("Pomppa");
			manufacturerRepository.save(pomppa);

			Manufacturer hurtta = new Manufacturer("Hurtta");
			manufacturerRepository.save(hurtta);

			Type vaate = new Type("Vaate");
			typeRepository.save(vaate);
			Type lelu = new Type("Lelu");
			typeRepository.save(lelu);

			Product p1 = new Product("Ulkoilutakki", "Sininen", "S", 15.00, vaate, rukka);
			productRepository.save(p1);
			Product p2 = new Product("Vinkulelu", "Keltainen", "S", 45.00, lelu, martta);
			productRepository.save(p2);

		};
	}
}