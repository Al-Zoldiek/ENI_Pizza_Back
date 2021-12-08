package fr.eni.ecole.app.data;

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
import fr.eni.ecole.app.pizzas.Pizza;
import fr.eni.ecole.app.pizzas.PizzaRepo;

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

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		crustRepository.save(new Crust("Fine"));
		crustRepository.save(new Crust("Epaisse"));
		crustRepository.save(new Crust("Mozza-crust"));
		
		sauceRepository.save(new Sauce("Crème"));
		sauceRepository.save(new Sauce("Tomate"));

		toppingRepository.save(new Topping("Jambon","Viande"));
		toppingRepository.save(new Topping("Jambon cru","Viande"));
		toppingRepository.save(new Topping("Chorizo","Viande"));
		toppingRepository.save(new Topping("Saucisses","Viande"));
		toppingRepository.save(new Topping("Boeuf haché", "Viande"));
		toppingRepository.save(new Topping("Poulet rôti", "Viande"));
		toppingRepository.save(new Topping("Lardons", "Viande"));
		
		toppingRepository.save(new Topping("Mozzarella","Fromage"));
		toppingRepository.save(new Topping("Emmental","Fromage"));
		toppingRepository.save(new Topping("Chèvre","Fromage"));
		toppingRepository.save(new Topping("Bleu","Fromage"));
		toppingRepository.save(new Topping("Reblochon","Fromage"));
		
		toppingRepository.save(new Topping("Ananas","Fruit"));
		toppingRepository.save(new Topping("Olives","Fruit"));
		toppingRepository.save(new Topping("Tomates","Fruit"));
		
		toppingRepository.save(new Topping("Poivrons","Légume"));
		toppingRepository.save(new Topping("Oignon","Légume"));
		toppingRepository.save(new Topping("Coeur d'artichaut","Légume"));
		
		toppingRepository.save(new Topping("Champignons","Champignon"));
		
		toppingRepository.save(new Topping("Pommes de terre","Féculent"));
		
		toppingRepository.save(new Topping("Saumon","Poisson"));

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
	}




}

