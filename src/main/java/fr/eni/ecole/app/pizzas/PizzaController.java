package fr.eni.ecole.app.pizzas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ecole.app.ingredients.crust.CrustService;
import fr.eni.ecole.app.ingredients.sauce.SauceService;
import fr.eni.ecole.app.ingredients.toppings.ToppingService;

@CrossOrigin(origins="*")
@RestController
public class PizzaController {

	@Autowired
	PizzaService pizzaServ;
	@Autowired
	ToppingService toppingServ;
	@Autowired
	CrustService crustServ;
	@Autowired
	SauceService sauceServ;
	
	//Pour le formulaire des pizzas à choisir pour la commande
	@GetMapping({"/pizzas"})
	public List<Pizza> getAllPizzas(){
		return pizzaServ.getAllPizza();	
	}
	
	@GetMapping("/pizza/{pizzaId}")
	public Pizza getPizzaById(@PathVariable("pizzaId") Long pizzaId) {
		return pizzaServ.getPizzaById(pizzaId);
	}
	
	@PostMapping("/create-pizza")
	public void createPizza(@RequestBody Pizza pizza)  {
		pizzaServ.addPizza(pizza);
	} 
	
	@PostMapping("/delete-pizza")
	public void deletePizza(@RequestBody Pizza pizza) {
		try {
			pizzaServ.deletePizza(pizza);
		} catch (DataIntegrityViolationException exception) {
			System.err.println("Impossible de supprimer cette pizza ! Des commandes contenant celle-ci sont en cours.");
		}
		
	}
}
