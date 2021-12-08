package fr.eni.ecole.app.ingredients.sauce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SauceController {

	@Autowired
	SauceService sauceServ;
	
	@GetMapping("/sauce/{sauceId}")
	public Sauce sauce(@PathVariable("sauceId") Long sauceId) {
		return sauceServ.getSauceById(sauceId); 
	}
	
	@GetMapping("/sauces")
	public List<Sauce> sauces() {
		return sauceServ.getAllSauce(); 
	}
	
	@PostMapping("/create-sauce")
	public void createSauce(@RequestBody Sauce sauce) {
		sauceServ.createSauce(sauce);
	}
}
