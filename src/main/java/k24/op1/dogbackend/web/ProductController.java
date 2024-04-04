package k24.op1.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/productlist")
    public String showDogStore(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productlist";
    }

    @GetMapping("/addproduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }
    
    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute Product newProduct) {
        productRepository.save(newProduct);
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
        }
        return "editproduct";
    }
    
}
