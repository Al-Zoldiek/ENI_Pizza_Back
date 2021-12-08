package fr.eni.ecole.app.orders;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderController {

	@Autowired
	OrderService orderServ;

	@GetMapping("/orders")
	public List<Order> orders(){
		return orderServ.getAllOrders();
	}
	
	//---------------------------------------------------------------------------
	
	//ici, pas sur que ce soit bon, il faudra peut être recuperer une liste de pizza, une date et un status
	//pour creer l'order
	@PostMapping("/create-order")
	public void createOrder(@RequestBody Order order) {
		if(order.getDate() == null) {
			order.setDate(LocalDateTime.now());
		}
		orderServ.createOrder(order);
	}
	
	@PostMapping("/delete-order")
	public void deleteOrder(@RequestBody Order order) {
		orderServ.deleteOrder(order);
	}
	
	
}
