package k24.op1.dogbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;
import k24.op1.dogbackend.domain.AppUser;
import k24.op1.dogbackend.domain.AppUserRepository;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@SpringBootApplication
public class DogbackendApplication {
	private final AppUserRepository urepository;

	public DogbackendApplication(AppUserRepository urepository) {
		this.urepository = urepository;
	}

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
					new Product("Ulkoilutakki", "Lämmin takki talviulkoilulle", "Vaate", "Sininen", "S", 50.00, m1));

			// Username: user, password: user
			urepository
					.save(new AppUser("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
			// Username: admin, password: admin
			urepository.save(
					new AppUser("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));

		};
	}
}
