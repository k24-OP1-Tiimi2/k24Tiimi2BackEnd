package k24.op1.dogbackend.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import k24.op1.dogbackend.domain.Order;
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
    
    @PostMapping("/reservations")
    Iterable<Order> createReservations2(@RequestBody List<Order> newOrders) {
        System.out.println("Received reservations: " + newOrders);
        return orderRepository.saveAll(newOrders);
    }


   @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public @ResponseBody List<Order> getProductsRest() {
        return (List<Order>) orderRepository.findAll();
    }

}
