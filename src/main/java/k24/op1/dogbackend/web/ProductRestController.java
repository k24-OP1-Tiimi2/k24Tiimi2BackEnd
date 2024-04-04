package k24.op1.dogbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k24.op1.dogbackend.domain.Product;
import k24.op1.dogbackend.domain.ProductRepository;

@CrossOrigin
@Controller
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allproducts")
    public @ResponseBody List<Product> productListRest() {
        return (List<Product>) productRepository.findAll();
    }
}
