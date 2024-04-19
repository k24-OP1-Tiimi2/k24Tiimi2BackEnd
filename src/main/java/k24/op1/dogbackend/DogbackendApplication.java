package k24.op1.dogbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;

@SpringBootApplication
public class DogbackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository productRepository,
			ManufacturerRepository manufacturerRepository) {
		return (args) -> {

			Manufacturer m1 = new Manufacturer("Rukka", "Finland", "123-456");
			manufacturerRepository.save(m1);

			Manufacturer m2 = new Manufacturer("Martta", "Finland", "IVE-141");
			manufacturerRepository.save(m2);

			productRepository.save(
					new Product("Ulkoilutakki", "Lämmin takki talviulkoilulle", "Takki", "Sininen", "S", 50.00, m1));
			Product p1 = new Product("Sadetakki", "Sateen kestävä takki", "Takki", "Punainen", "S", 20.00, m2);
			productRepository.save(p1);
			Product p2 = new Product("T-Paita", "Kevyt paita", "Paita", "Oranssi", "M", 15.00, m2);
			productRepository.save(p2);

		};
	}
}