package fr.eni.ecole.app.pizzas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaService {
	
	@Autowired
	PizzaRepo pizzaRepo;
	
	public Pizza getPizzaById(Long id) {
		return pizzaRepo.findById(id).get();
	}
	
	public List<Pizza> getAllPizza(){
		return pizzaRepo.findAll();
	}
	
	public void addPizza(Pizza pizza) {
		pizzaRepo.save(pizza);
	}
	
	public void removePizza(Pizza pizza) {
		pizzaRepo.delete(pizza);
	}
	
	public void removePizzaById(Long pizzaId) {
		pizzaRepo.deleteById(pizzaId);
	}

}
