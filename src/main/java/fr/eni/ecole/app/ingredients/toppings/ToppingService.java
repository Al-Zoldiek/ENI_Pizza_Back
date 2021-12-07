package fr.eni.ecole.app.ingredients.toppings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {
	
	@Autowired
	ToppingRepo toppingRepo;

}
