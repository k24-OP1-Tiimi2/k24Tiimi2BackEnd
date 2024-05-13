package k24.op1.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import k24.op1.dogbackend.domain.ManufacturerRepository;
import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;
import k24.op1.dogbackend.domain.TypeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private TypeRepository typeRepository;

    

    @GetMapping("/productlist")
    public String showProductlist(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productlist";
    }

    @GetMapping("/addproduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
            return "addproduct";
        }
        productRepository.save(product);
        return "redirect:/productlist";
    }
    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            productRepository.deleteById(id);
        }
        return "redirect:/productlist";
    }
    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
            model.addAttribute("product", product);
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
        }
        return "editproduct";
    }

}