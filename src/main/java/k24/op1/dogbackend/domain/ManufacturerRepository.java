package k24.op1.dogbackend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import k24.op1.dogbackend.domain.Product;


public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    List<Manufacturer> findByName(@Param("name") String name);

    List<Manufacturer> findByNameContainingIgnoreCase(String name);

    List<Manufacturer> findByProducts(List<Product> products);

}
