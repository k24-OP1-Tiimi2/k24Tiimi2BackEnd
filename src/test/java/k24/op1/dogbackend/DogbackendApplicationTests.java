package k24.op1.dogbackend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.web.ManufacturerController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DogbackendApplicationTests {

	@Autowired
	private ManufacturerController manufacturerController;

	@Autowired
	private ManufacturerRepository manufacturerRepository;


	@Test
	public void contextLoads() throws Exception {
		assertThat(manufacturerController).isNotNull();
	}

	@Test
	 public void findByNameShouldReturnManufacturer() {
		List<Manufacturer> manufacturers = manufacturerRepository.findByName("Rukka");
		assertThat(manufacturers).hasSize(1);
		assertThat(manufacturers.get(0).getName()).isEqualTo("Rukka");
	 }

	 /* 
	 @Test
	 public void createNewManufacturer() {
	   Manufacturer manufacturer = new Manufacturer("Balenciaga", "United States", "USA-510");
	   manufacturerRepository.save(manufacturer);
	   assertThat(manufacturer.getId()).isNotNull();
	 } */

	 /* 
	 @Test
	 public void createNewManufacturerAndDelete() {
	   Manufacturer manufacturer = new Manufacturer("Balenciaga", "United States", "USA-510");
	   manufacturerRepository.save(manufacturer);
	   manufacturerRepository.deleteById(2L);
	   assertThat(manufacturerRepository.findById(2L).isEmpty());
	 } */


}
