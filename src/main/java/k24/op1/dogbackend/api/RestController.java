package k24.op1.dogbackend.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import k24.op1.dogbackend.domain.Manufacturer;
import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
public class RestController {
    
    @Autowired
    private ProductRepository ProductRepository;

    @Autowired
    private ManufacturerRepository ManufacturerRepository;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsRest() {
        return (List<Product>) ProductRepository.findAll();
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Product> getProductByIdRest(@PathVariable("id") Long id) {
        return ProductRepository.findById(id);
    }

    @RequestMapping(value="/manufacturers", method = RequestMethod.GET)
    public @ResponseBody List<Manufacturer> getManufacturersRest() {
        return (List<Manufacturer>) ManufacturerRepository.findAll();
    }

    @RequestMapping(value="/manufacturers/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Manufacturer> getManufacturerByIdRest(@PathVariable("id") Long id) {
        return ManufacturerRepository.findById(id);
    }
    @RequestMapping(value = "/products/jackets", method = RequestMethod.GET)
    public @ResponseBody List<Product> getJackets() {
        return ProductRepository.findByType("Takki");
    }
}
