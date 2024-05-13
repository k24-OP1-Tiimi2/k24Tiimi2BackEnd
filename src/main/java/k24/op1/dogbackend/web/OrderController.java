package k24.op1.dogbackend.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k24.op1.dogbackend.domain.OrderRepository;

@CrossOrigin(origins = "*")
@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orderlist")
    public String showOrderList(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orderlist";
    }

    @GetMapping("/orderdetails/{id}")
    public String showOrderDetails(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderRepository.findById(id).orElse(null));
        return "orderdetails";
    }

}
