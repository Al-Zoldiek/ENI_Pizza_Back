package fr.eni.ecole.app.pizzas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	PizzaRepo pizzaRepo;

}
