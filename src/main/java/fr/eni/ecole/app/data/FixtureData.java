package fr.eni.ecole.app.data;

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

@Component
public class FixtureData {
	
	
	@Autowired
	private CrustRepo crustRepository;
	
	@Autowired
	private SauceRepo sauceRepository;
	
	@Autowired
	private ToppingRepo toppingRepository;

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
		toppingRepository.save(new Topping("Mozzarella","Fromage"));
		toppingRepository.save(new Topping("Emmental","Fromage"));
		toppingRepository.save(new Topping("Chèvre","Fromage"));
		toppingRepository.save(new Topping("Bleu","Fromage"));
		toppingRepository.save(new Topping("Ananas","Fruit"));
		toppingRepository.save(new Topping("Olives","Fruit"));
		toppingRepository.save(new Topping("Tomates","Fruit"));
		toppingRepository.save(new Topping("Poivrons","Fruit"));
		toppingRepository.save(new Topping("Champignons","Champignon"));
		toppingRepository.save(new Topping("Carrés de pommes de terre","Féculent"));
		toppingRepository.save(new Topping("Saumon","Poisson"));
	}
	



}

