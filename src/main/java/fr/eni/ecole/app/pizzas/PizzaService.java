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
	
	public void addPizza(Pizza votrePizza) {
		pizzaRepo.save(votrePizza);
	}
	
	public void removePizza(Pizza votrePizza) {
		pizzaRepo.delete(votrePizza);
	}
	
	public void removePizzaById(Long pizzaId) {
		pizzaRepo.deleteById(pizzaId);
	}

}
