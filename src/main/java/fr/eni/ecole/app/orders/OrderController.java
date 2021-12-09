package fr.eni.ecole.app.orders;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins="*")
@RestController
public class OrderController {

	@Autowired
	OrderService orderServ;

	@GetMapping("/orders")
	public List<Order> orders(){
		return orderServ.getAllOrders();
	}
	
	@PostMapping("/create-order")
	public void createOrder(@RequestBody Order order) {
		if(order.getDate() == null) {
			order.setDate(LocalDateTime.now());
		}
		orderServ.createOrder(order);
	}
	
	@PostMapping("/delete-order")
	public void deleteOrder(@RequestBody Order order) {
		try {
			orderServ.deleteOrder(order);
		} catch (DataIntegrityViolationException exception) {
			System.err.println("Impossible de supprimer cette commande !");
		}
		
		
	}
	
	
}
