package fr.eni.ecole.app.orders;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ecole.app.pizzas.Pizza;


@RestController
public class OrderController {

	@Autowired
	OrderService orderServ;

	@GetMapping("/orders")
	public List<Order> orders(){
		return orderServ.getAllOrder();
	}
	
	//---------------------------------------------------------------------------
	
	//ici, pas sur que ce soit bon, il faudra peut être recuperer une liste de pizza, une date et un status
	//pour creer l'order
	@PostMapping("/your-order")
	public ResponseEntity<Order> yourOrder(@RequestBody Order yourOrder) {
		orderServ.addOrder(yourOrder);
		return new ResponseEntity<Order>(yourOrder, HttpStatus.CREATED);
	}
	
	//ou
	//une date dans une URL, pas sur que ce soit possible...
	@PostMapping("/your-order2/{dateOrder}/{status}")
	public void yourOrder2(
			@PathVariable("dateOrder") LocalDateTime dateOrder,
			@PathVariable("status") String status,
			@RequestBody List<Pizza> pizzasOrdered) {
		orderServ.addOrder(new Order(dateOrder, status, pizzasOrdered));
	}
}
