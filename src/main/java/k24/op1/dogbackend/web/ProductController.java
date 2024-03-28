package k24.op1.dogbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import k24.op1.dogbackend.domain.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/dogstore")
    public String showDogStore(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "dogstore";
    }
    
}
