package k24.op1.dogbackend.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k24.op1.dogbackend.domain.Order;
import k24.op1.dogbackend.domain.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    @PostMapping("/reservations")
    // public ResponseEntity<String> createReservation(@RequestBody Order Order) {
        // Logic to save the reservation to a database or perform any other actions
        Order createReservation(@RequestBody Order newOrder) {
        System.out.println("Received reservation: " + newOrder);
        return orderRepository.save(newOrder);
      //  return ResponseEntity.ok("Reservation received successfully");
    }
    
}
