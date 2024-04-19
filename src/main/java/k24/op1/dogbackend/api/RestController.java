package k24.op1.dogbackend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    // haku manufacturer listaan.
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchManufacturers(@RequestParam("searchTerm") String searchTerm,
            @RequestParam("searchBy") String searchBy,
            Model model) {
        List<Manufacturer> manufacturers;
        if (searchBy.equals("name")) {
            manufacturers = ManufacturerRepository.findByNameContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("country")) {
            manufacturers = ManufacturerRepository.findByCountryContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("businessid")) {
            manufacturers = ManufacturerRepository.findByBusinessidContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("all")) {
            // etsitään kaikki kategoriat
            List<Manufacturer> byName = ManufacturerRepository.findByNameContainingIgnoreCase(searchTerm);
            List<Manufacturer> byCountry = ManufacturerRepository.findByCountryContainingIgnoreCase(searchTerm);
            List<Manufacturer> byBusinessId = ManufacturerRepository.findByBusinessidContainingIgnoreCase(searchTerm);

            // yhdistetään tulokset
            manufacturers = new ArrayList<>();
            manufacturers.addAll(byName);
            manufacturers.addAll(byCountry);
            manufacturers.addAll(byBusinessId);
        } else {
            // name defaultiksi
            manufacturers = ManufacturerRepository.findByNameContainingIgnoreCase(searchTerm);
        }
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturerlist";
    }

    // haku products
    @RequestMapping(value = "/searchproducts", method = RequestMethod.GET)
    public String searchProducts(@RequestParam("searchTerm") String searchTerm,
            @RequestParam("searchBy") String searchBy,
            Model model) {
        List<Product> products;
        if (searchBy.equals("name")) {
            products = ProductRepository.findByNameContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("description")) {
            products = ProductRepository.findByDescriptionContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("type")) {
            products = ProductRepository.findByTypeContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("color")) {
            products = ProductRepository.findByColorContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("size")) {
            products = ProductRepository.findBySizeContainingIgnoreCase(searchTerm);
        } else if (searchBy.equals("all")) {
            // Etsitään kaikki kategoriat
            List<Product> byName = ProductRepository.findByNameContainingIgnoreCase(searchTerm);
            List<Product> byDescription = ProductRepository.findByDescriptionContainingIgnoreCase(searchTerm);
            List<Product> byType = ProductRepository.findByTypeContainingIgnoreCase(searchTerm);
            List<Product> byColor = ProductRepository.findByColorContainingIgnoreCase(searchTerm);
            List<Product> bySize = ProductRepository.findBySizeContainingIgnoreCase(searchTerm);

            // Yhdistetään tulokset
            products = new ArrayList<>();
            products.addAll(byName);
            products.addAll(byDescription);
            products.addAll(byType);
            products.addAll(byColor);
            products.addAll(bySize);
        } else {
            // Name defaultiksi
            products = ProductRepository.findByNameContainingIgnoreCase(searchTerm);
        }
        model.addAttribute("products", products);
        return "productlist";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsRest() {
        return (List<Product>) ProductRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Product> getProductByIdRest(@PathVariable("id") Long id) {
        return ProductRepository.findById(id);
    }

    @RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
    public @ResponseBody List<Manufacturer> getManufacturersRest() {
        return (List<Manufacturer>) ManufacturerRepository.findAll();
    }

    @RequestMapping(value = "/manufacturers/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Manufacturer> getManufacturerByIdRest(@PathVariable("id") Long id) {
        return ManufacturerRepository.findById(id);
    }

    @RequestMapping(value = "/products/jackets", method = RequestMethod.GET)
    public @ResponseBody List<Product> getJackets() {
        return ProductRepository.findByType("Takki");
    }
}
