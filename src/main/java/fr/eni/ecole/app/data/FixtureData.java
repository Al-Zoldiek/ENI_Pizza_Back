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
		
		crustRepository.save(new Crust("Fine")); //1
		crustRepository.save(new Crust("Epaisse")); //2
		crustRepository.save(new Crust("Mozza-crust")); //3
		
		sauceRepository.save(new Sauce("Crème")); //1
		sauceRepository.save(new Sauce("Tomate")); //2

		toppingRepository.save(new Topping("Jambon","Viande")); //1
		toppingRepository.save(new Topping("Jambon cru","Viande")); //2
		toppingRepository.save(new Topping("Chorizo","Viande")); //3
		toppingRepository.save(new Topping("Saucisses","Viande")); //4
		toppingRepository.save(new Topping("Boeuf haché","Viande")); //5
		toppingRepository.save(new Topping("Poulet rôti","Viande")); //6
		toppingRepository.save(new Topping("Lardons","Viande")); //7
		toppingRepository.save(new Topping("Bacon","Viande")); //8
		toppingRepository.save(new Topping("Oeuf","Viande")); //9
		
		toppingRepository.save(new Topping("Saumon","Poisson")); //10
		toppingRepository.save(new Topping("Thon","Poisson")); //11
		toppingRepository.save(new Topping("Anchois","Poisson")); //12
		toppingRepository.save(new Topping("Gambas","Poisson")); //13
		
		toppingRepository.save(new Topping("Mozzarella","Fromage")); //14
		toppingRepository.save(new Topping("Emmental","Fromage")); //15
		toppingRepository.save(new Topping("Chèvre","Fromage")); //16
		toppingRepository.save(new Topping("Feta","Fromage")); //17
		toppingRepository.save(new Topping("Bleu","Fromage")); //18
		toppingRepository.save(new Topping("Reblochon","Fromage")); //19
		toppingRepository.save(new Topping("Raclette","Fromage")); //20
		
		toppingRepository.save(new Topping("Ananas","Légumes")); //21
		toppingRepository.save(new Topping("Olives","Légumes")); //22
		toppingRepository.save(new Topping("Tomates","Légumes")); //23	
		toppingRepository.save(new Topping("Poivrons","Légumes")); //24
		toppingRepository.save(new Topping("Oignon","Légumes")); //25
		toppingRepository.save(new Topping("Coeur d'artichaut","Légumes")); //26		
		toppingRepository.save(new Topping("Champignons","Légumes")); //27
		toppingRepository.save(new Topping("Epinards","Légumes")); //28
		toppingRepository.save(new Topping("Pommes de terre","Légumes")); //29
		toppingRepository.save(new Topping("Piments","Légumes")); //30
		
		toppingRepository.save(new Topping("Pesto","Assaisonnement")); //31		
		toppingRepository.save(new Topping("Chimichurri","Assaisonnement")); //32
		toppingRepository.save(new Topping("Harissa","Assaisonnement")); //33
		toppingRepository.save(new Topping("Tabasco","Assaisonnement")); //34
		toppingRepository.save(new Topping("Huile de truffe","Assaisonnement")); //35
		toppingRepository.save(new Topping("Origan","Assaisonnement")); //36
		toppingRepository.save(new Topping("Basilic","Assaisonnement")); //37
		toppingRepository.save(new Topping("Thym","Assaisonnement")); //38
	
		ArrayList<Topping> margaTop = new ArrayList<Topping>();
		margaTop.add(toppingRepository.getById(23L));
		margaTop.add(toppingRepository.getById(14L));
		margaTop.add(toppingRepository.getById(39L));
		Pizza margarita = new Pizza("Margarita", 
				margaTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(1L));
		pizzaRepository.save(margarita);
		
		ArrayList<Topping> reginTop = new ArrayList<Topping>();
		reginTop.add(toppingRepository.getById(1L));
		reginTop.add(toppingRepository.getById(14L));
		reginTop.add(toppingRepository.getById(22L));
		reginTop.add(toppingRepository.getById(27L));
		reginTop.add(toppingRepository.getById(38L));
		Pizza regina = new Pizza("Regina", 
				reginTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(1L));
		pizzaRepository.save(regina);
		
		ArrayList<Topping> arrabiaTop = new ArrayList<Topping>();
		arrabiaTop.add(toppingRepository.getById(3L));
		arrabiaTop.add(toppingRepository.getById(24L));
		arrabiaTop.add(toppingRepository.getById(30L));
		arrabiaTop.add(toppingRepository.getById(35L));
		Pizza arrabiata = new Pizza("Arrabiata", 
				arrabiaTop, 
				crustRepository.getById(2L), 
				sauceRepository.getById(1L));
		pizzaRepository.save(arrabiata);

		List<Topping> canniTop = new ArrayList<Topping>();
		canniTop.add(toppingRepository.getById(3L));
		canniTop.add(toppingRepository.getById(5L));
		canniTop.add(toppingRepository.getById(6L));
		canniTop.add(toppingRepository.getById(23L));
		canniTop.add(toppingRepository.getById(36L));
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
		
		List<Topping> alsaTop = new ArrayList<Topping>();
		alsaTop.add(toppingRepository.getById(7L));
		alsaTop.add(toppingRepository.getById(15L));
		alsaTop.add(toppingRepository.getById(25L));
		Pizza alsacienne = new Pizza("Alsacienne", 
				alsaTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(alsacienne);

		List<Topping> quatSaisTop = new ArrayList<Topping>();
		quatSaisTop.add(toppingRepository.getById(22L));
		quatSaisTop.add(toppingRepository.getById(23L));
		quatSaisTop.add(toppingRepository.getById(24L));
		quatSaisTop.add(toppingRepository.getById(25L));
		quatSaisTop.add(toppingRepository.getById(26L));
		quatSaisTop.add(toppingRepository.getById(27L));
		quatSaisTop.add(toppingRepository.getById(28L));
		quatSaisTop.add(toppingRepository.getById(31L));
		Pizza quatSaisons = new Pizza("Quatre Saisons", 
				quatSaisTop, 
				crustRepository.getById(2L), 
				sauceRepository.getById(1L));
		pizzaRepository.save(quatSaisons);
		
		List<Topping> cabbriTop = new ArrayList<Topping>();
		cabbriTop.add(toppingRepository.getById(7L));
		cabbriTop.add(toppingRepository.getById(16L));
		cabbriTop.add(toppingRepository.getById(32L));
		cabbriTop.add(toppingRepository.getById(40L));
		Pizza cabbria = new Pizza("La Cabbria", 
				quatSaisTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(cabbria);
		
		ArrayList<Topping> hawaiTop = new ArrayList<Topping>();
		hawaiTop.add(toppingRepository.getById(1L));
		hawaiTop.add(toppingRepository.getById(14L));
		hawaiTop.add(toppingRepository.getById(21L));
		Pizza hawaienne = new Pizza("Hawaienne", 
				hawaiTop, 
				crustRepository.getById(3L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(hawaienne);
		
		ArrayList<Topping> norvegTop = new ArrayList<Topping>();
		norvegTop.add(toppingRepository.getById(10L));
		norvegTop.add(toppingRepository.getById(14L));
		norvegTop.add(toppingRepository.getById(28L));
		Pizza norvegienne = new Pizza("Norvegienne", 
				norvegTop, 
				crustRepository.getById(2L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(norvegienne);
		
		ArrayList<Topping> mexiTop = new ArrayList<Topping>();
		mexiTop.add(toppingRepository.getById(5L));
		mexiTop.add(toppingRepository.getById(9L));
		mexiTop.add(toppingRepository.getById(14L));
		mexiTop.add(toppingRepository.getById(24L));
		mexiTop.add(toppingRepository.getById(30L));
		Pizza mexicaine = new Pizza("Mexicana", 
				mexiTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(mexicaine);
		
		ArrayList<Topping> argenTop = new ArrayList<Topping>();
		argenTop.add(toppingRepository.getById(3L));
		argenTop.add(toppingRepository.getById(5L));
		argenTop.add(toppingRepository.getById(17L));
		argenTop.add(toppingRepository.getById(23L));
		argenTop.add(toppingRepository.getById(33L));
		Pizza argentina = new Pizza("Argentina", 
				argenTop, 
				crustRepository.getById(1L), 
				sauceRepository.getById(2L));
		pizzaRepository.save(argentina);
		
		List<Pizza> firstPizzaList = new ArrayList<Pizza>();
		firstPizzaList.add(pizzaRepository.getById(1L));
		firstPizzaList.add(pizzaRepository.getById(2L));
		firstPizzaList.add(pizzaRepository.getById(3L));
		Order firstOrder = new Order(
				LocalDateTime.now(),
				"En attente de livraison",
				firstPizzaList,
				userErwan
				);
		orderRepository.save(firstOrder);
		
		List<Pizza> secondPizzaList = new ArrayList<Pizza>();
		secondPizzaList.add(pizzaRepository.getById(2L));
		secondPizzaList.add(pizzaRepository.getById(5L));
		secondPizzaList.add(pizzaRepository.getById(6L));
		Order secondOrder = new Order(
				LocalDateTime.now(),
				"Livré",
				secondPizzaList,
				userErwan
				);
		orderRepository.save(secondOrder);
		
		List<Pizza> thirdPizzaList = new ArrayList<Pizza>();
		thirdPizzaList.add(pizzaRepository.getById(2L));
		thirdPizzaList.add(pizzaRepository.getById(4L));
		thirdPizzaList.add(pizzaRepository.getById(7L));
		thirdPizzaList.add(pizzaRepository.getById(8L));
		thirdPizzaList.add(pizzaRepository.getById(10L));
		Order thirdOrder = new Order(
				LocalDateTime.now(),
				"Livré",
				thirdPizzaList,
				userErwan
				);
		orderRepository.save(thirdOrder);
		
		List<Pizza> fourthPizzaList = new ArrayList<Pizza>();
		fourthPizzaList.add(pizzaRepository.getById(1L));
		fourthPizzaList.add(pizzaRepository.getById(3L));
		fourthPizzaList.add(pizzaRepository.getById(6L));
		fourthPizzaList.add(pizzaRepository.getById(9L));
		Order fourthOrder = new Order(
				LocalDateTime.now(),
				"Livré",
				fourthPizzaList,
				userErwan
				);
		orderRepository.save(fourthOrder);
		
	}




}

