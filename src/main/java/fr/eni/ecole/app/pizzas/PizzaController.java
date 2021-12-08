package fr.eni.ecole.app.pizzas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//Un get pour pouvoir recuperer une pizza de la bdd à partir du front avec son id
	@GetMapping("/pizza/{pizzaId}")
	public Pizza pizza(@PathVariable("pizzaId") Long pizzaId) {
		return pizzaServ.getPizzaById(pizzaId);
	}
	
	//Un get pour pouvoir supprimer une pizza de la bdd à partir du front avec son id
	@GetMapping("/remove-pizza-by-id/{pizzaId}")
	public void removePizzaById(@PathVariable("pizzaId") Long pizzaId) {
		pizzaServ.removePizzaById(pizzaId);
	}
	
	//Pour le formulaire des pizzas à choisir pour la commande
	@GetMapping({"/pizzas"})
	public List<Pizza> pizzas(){
		return pizzaServ.getAllPizza();	
	}
	
	//-----------------------------------------------------------
	
//	//Pour le formulaire de création de la pizza. 
//	//Comment on retourne les 3? (sauce, crust, topping)
//	@GetMapping("/pizza-creation")
//	public void formToppingSauceCrust() {
//		toppingServ.getAllTopping();
//		sauceServ.getAllSauce();
//		crustServ.getAllCrust();
//	}
	
	//Pour pouvoir creer une pizza à partir du Front : 
	//(Pas bon à mon avis)
	@PostMapping("/pizza-creation")
	public void pizzaCreation(@RequestBody Pizza pizza)  {
		pizzaServ.addPizza(pizza);
	} 
	
	//ou
	@PostMapping("/pizza-creation2")
	public ResponseEntity<Pizza> pizzaCreation2(@RequestBody Pizza yourPizza) {
		pizzaServ.addPizza(yourPizza);
		return new ResponseEntity<Pizza>(yourPizza, HttpStatus.CREATED);
	}
	
	
}
