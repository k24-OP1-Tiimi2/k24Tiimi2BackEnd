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
	public CommandLineRunner initData(ProductRepository productRepository, ManufacturerRepository manufacturerRepository) {
		return (args) -> {

			Manufacturer m1 = new Manufacturer("Rukka", "Finland", "123-456");
			manufacturerRepository.save(m1);

			productRepository.save(new Product("Ulkoilutakki", "Lämmin takki talviulkoilulle", "Vaate", "Sininen", "S", 50.00, m1));

};
}
}