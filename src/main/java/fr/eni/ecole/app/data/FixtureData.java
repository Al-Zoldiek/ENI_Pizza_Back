package fr.eni.ecole.app.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.eni.ecole.app.ingredients.crust.Crust;
import fr.eni.ecole.app.ingredients.crust.CrustRepo;
import fr.eni.ecole.app.ingredients.sauce.Sauce;
import fr.eni.ecole.app.ingredients.sauce.SauceRepo;
import fr.eni.ecole.app.ingredients.toppings.Topping;
import fr.eni.ecole.app.ingredients.toppings.ToppingRepo;
import fr.eni.ecole.app.orders.Order;
import fr.eni.ecole.app.orders.OrderRepo;
import fr.eni.ecole.app.pizzas.Pizza;
import fr.eni.ecole.app.pizzas.PizzaRepo;
import fr.eni.ecole.app.users.User;
import fr.eni.ecole.app.users.UserRepo;

@Component
public class FixtureData {


	@Autowired
	private CrustRepo crustRepository;

	@Autowired
	private SauceRepo sauceRepository;

	@Autowired
	private ToppingRepo toppingRepository;

	@Autowired
	private PizzaRepo pizzaRepository;
	
	@Autowired
	private OrderRepo orderRepository;
	
	@Autowired
	private UserRepo userRepository;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		
		User userErwan = userRepository.save(new User("Erwan"));
		
		crustRepository.save(new Crust("Fine"));
		crustRepository.save(new Crust("Epaisse"));
		crustRepository.save(new Crust("Mozza-crust"));
		
		sauceRepository.save(new Sauce("Crème"));
		sauceRepository.save(new Sauce("Tomate"));

		toppingRepository.save(new Topping("Jambon","Animal"));
		toppingRepository.save(new Topping("Jambon cru","Animal"));
		toppingRepository.save(new Topping("Chorizo","Animal"));
		toppingRepository.save(new Topping("Saucisses","Animal"));
		toppingRepository.save(new Topping("Boeuf haché", "Animal"));
		toppingRepository.save(new Topping("Poulet rôti", "Animal"));
		toppingRepository.save(new Topping("Lardons", "Animal"));
		toppingRepository.save(new Topping("Saumon","Animal"));
		
		toppingRepository.save(new Topping("Mozzarella","Fromage"));
		toppingRepository.save(new Topping("Emmental","Fromage"));
		toppingRepository.save(new Topping("Chèvre","Fromage"));
		toppingRepository.save(new Topping("Bleu","Fromage"));
		toppingRepository.save(new Topping("Reblochon","Fromage"));
		
		toppingRepository.save(new Topping("Ananas","Végétal"));
		toppingRepository.save(new Topping("Olives","Végétal"));
		toppingRepository.save(new Topping("Tomates","Végétal"));		
		toppingRepository.save(new Topping("Poivrons","Végétal"));
		toppingRepository.save(new Topping("Oignon","Végétal"));
		toppingRepository.save(new Topping("Coeur d'artichaut","Végétal"));		
		toppingRepository.save(new Topping("Champignons","Végétal"));		
		toppingRepository.save(new Topping("Pommes de terre","Végétal"));
		
		

		ArrayList<Topping> margaTop = new ArrayList<Topping>();
		margaTop.add(toppingRepository.getById(1L));
		margaTop.add(toppingRepository.getById(8L));
		margaTop.add(toppingRepository.getById(19L));
		Pizza margarita = new Pizza("Margarita", 
				margaTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(margarita);

		List<Topping> canniTop = new ArrayList<Topping>();
		canniTop.add(toppingRepository.getById(3L));
		canniTop.add(toppingRepository.getById(16L));
		canniTop.add(toppingRepository.getById(15L));
		canniTop.add(toppingRepository.getById(1L));
		canniTop.add(toppingRepository.getById(5L));
		canniTop.add(toppingRepository.getById(6L));
		Pizza cannibale = new Pizza("Cannibale", 
				canniTop, 
				crustRepository.getById(2L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(cannibale);

		List<Topping> savoyTop = new ArrayList<Topping>();
		savoyTop.add(toppingRepository.getById(20L));
		savoyTop.add(toppingRepository.getById(17L));
		savoyTop.add(toppingRepository.getById(7L));
		savoyTop.add(toppingRepository.getById(12L));
		Pizza savoyarde = new Pizza("Savoyarde", 
				savoyTop, 
				crustRepository.getById(2L), 
				sauceRepository.getById(1L));
		pizzaRepository.save(savoyarde);

		List<Topping> quatSaisTop = new ArrayList<Topping>();
		quatSaisTop.add(toppingRepository.getById(18L));
		quatSaisTop.add(toppingRepository.getById(14L));
		quatSaisTop.add(toppingRepository.getById(16L));
		quatSaisTop.add(toppingRepository.getById(19L));
		quatSaisTop.add(toppingRepository.getById(15L));
		Pizza quatSaisons = new Pizza("Quatre saisons", 
				quatSaisTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(quatSaisons);
		
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(pizzaRepository.getById(1L));
		pizzaList.add(pizzaRepository.getById(2L));
		pizzaList.add(pizzaRepository.getById(3L));
		Order order = new Order(
				LocalDateTime.now(),
				"En attente de livraison",
				pizzaList,
				userErwan
				);
		orderRepository.save(order);
		
	}




}

