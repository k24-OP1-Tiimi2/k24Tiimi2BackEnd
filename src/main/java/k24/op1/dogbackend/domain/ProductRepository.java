package k24.op1.dogbackend.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByType(String type);
}
