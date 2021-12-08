package fr.eni.ecole.app.ingredients.toppings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class ToppingController {

	@Autowired
	ToppingService toppingServ;
	
	@GetMapping("/topping/{toppingId}")
	public Topping topping(@PathVariable("toppingId") Long toppingId) {
		return toppingServ.getToppingById(toppingId); 
	}
	
	@GetMapping("/toppings")
	public List<Topping> toppings() {
		return toppingServ.getAllTopping(); 
	}
	
	@PostMapping("/create-topping")
	@ResponseBody
	public void createTopping(@RequestBody Topping topping) {	
		toppingServ.createTopping(topping);
	}
	
	@PostMapping("/delete-topping")
	public void deleteTopping(@RequestBody Topping topping) {
		toppingServ.deleteTopping(topping);
	}
}
