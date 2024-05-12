package k24.op1.dogbackend;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Order;
import k24.op1.dogbackend.domain.OrderRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;
import k24.op1.dogbackend.domain.Type;
import k24.op1.dogbackend.domain.TypeRepository; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import k24.op1.dogbackend.domain.AppUser;
import k24.op1.dogbackend.domain.AppUserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DogbackendApplication {
	private static final Logger log = LoggerFactory.getLogger(DogbackendApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DogbackendApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductRepository productRepository,
			ManufacturerRepository manufacturerRepository, TypeRepository typeRepository,
			AppUserRepository auRepository, OrderRepository orderRepository) {

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
			 Type ruoka = new Type("Ruoka");
			 typeRepository.save(ruoka);
			  
			 Product p1 = new Product("Ulkoilutakki", "Sininen", "S", 15.00, 25, vaate,
			 rukka);
			 productRepository.save(p1);
			 Product p2 = new Product("Vinkulelu", "Keltainen", "-", 5.00, 25, lelu,
			 martta);
			 productRepository.save(p2);
			 Product p3 = new Product("Sadetakki", "Punainen", "M", 25.00, 100, vaate,
			 pomppa);
			 productRepository.save(p3);
			 Product p4 = new Product("T-paita", "Valkoinen", "L", 10.00, 50, vaate,
			 hurtta);
			 productRepository.save(p4);
			 Product p5 = new Product("Purulelu", "Sini-valkoinen", "-", 7.50, 50, lelu,
			 rukka);
			 productRepository.save(p5);
			 Product p6 = new Product("Kuivaruoka", "-", "-", 7.80, 50, ruoka,
			 rukka);
			 productRepository.save(p6);


			 if (auRepository.findByUsername("admin") == null) {
			 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 String encodedPassword = passwordEncoder.encode("admin");
			 AppUser admin = new AppUser("admin", encodedPassword, "ADMIN");
			 auRepository.save(admin);
			 }
		};
	}
}