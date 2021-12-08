package fr.eni.ecole.app.ingredients.toppings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {
	
	@Autowired
	ToppingRepo toppingRepo;

	public Topping getToppingById(Long id) {
		return toppingRepo.findById(id).get();
	}
	
	public List<Topping> getAllTopping(){
		System.out.println("getAllTopping()");
		return toppingRepo.findAll();
	}
	
	public void createTopping(Topping topping) {
		toppingRepo.save(topping);
	}
}
