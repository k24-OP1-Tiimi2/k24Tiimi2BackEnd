package k24.op1.dogbackend.web;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k24.op1.dogbackend.domain.Order;


@RestController
public class OrderController {
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/reservations")
    public ResponseEntity<String> createReservation(@RequestBody Order Order) {
        // Logic to save the reservation to a database or perform any other actions
        System.out.println("Received reservation: " + Order);
        return ResponseEntity.ok("Reservation received successfully");
    }
}
