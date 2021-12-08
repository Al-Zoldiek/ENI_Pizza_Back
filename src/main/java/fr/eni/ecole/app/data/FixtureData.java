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
		margaTop.add(new Topping("Jambon","Viande"));
		margaTop.add(new Topping("Mozzarella","Fromage"));
		margaTop.add(new Topping("Champignons","Champignon"));
		Pizza margarita = new Pizza("Margarita", margaTop, new Crust("Fine"), new Sauce("Tomate"));
		pizzaRepository.save(margarita);

		List<Topping> canniTop = new ArrayList<Topping>();
		canniTop.add(new Topping("Chorizo","Viande"));
		canniTop.add(new Topping("Poivrons","Fruit"));
		canniTop.add(new Topping("Tomates","Fruit"));
		canniTop.add(new Topping("Jambon","Viande"));
		canniTop.add(new Topping("Boeuf haché", "Viande"));
		canniTop.add(new Topping("Poulet rôti", "Viande"));
		Pizza cannibale = new Pizza("Cannibale", canniTop, new Crust("Epaisse"), new Sauce("Tomate"));
		pizzaRepository.save(cannibale);

		List<Topping> savoyTop = new ArrayList<Topping>();
		savoyTop.add(new Topping("Pommes de terre","Féculent"));
		savoyTop.add(new Topping("Oignon","Légume"));
		savoyTop.add(new Topping("Lardons", "Viande"));
		savoyTop.add(new Topping("Reblochon","Fromage"));
		Pizza savoyarde = new Pizza("Savoyarde", savoyTop, new Crust("Epaisse"), new Sauce("Crème"));
		pizzaRepository.save(savoyarde);

		List<Topping> quatSaisTop = new ArrayList<Topping>();
		quatSaisTop.add(new Topping("Coeur d'artichaut","Légume"));
		quatSaisTop.add(new Topping("Olives","Fruit"));
		quatSaisTop.add(new Topping("Poivrons","Légume"));
		quatSaisTop.add(new Topping("Champignons","Champignon"));
		quatSaisTop.add(new Topping("Tomates","Fruit"));
		Pizza quatSaisons = new Pizza("Quatre saisons", quatSaisTop, new Crust("Mozza-crust"), new Sauce("Tomate"));
		pizzaRepository.save(quatSaisons);
	}




}

