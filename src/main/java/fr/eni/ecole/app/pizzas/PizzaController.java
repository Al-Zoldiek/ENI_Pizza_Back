package fr.eni.ecole.app.pizzas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

	@Autowired
	PizzaService pizzaServ;
	
	@GetMapping("/home")
	public void home() {
		
	}
}
