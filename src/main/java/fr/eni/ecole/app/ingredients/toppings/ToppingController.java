package fr.eni.ecole.app.ingredients.toppings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToppingController {

	@Autowired
	ToppingService toppingServ;
}
