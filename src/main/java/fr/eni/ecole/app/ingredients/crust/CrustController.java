package fr.eni.ecole.app.ingredients.crust;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CrustController {

	@Autowired
	CrustService crustServ;
	
	@GetMapping("/crust/{crustId}")
	public Crust crust(@PathVariable("crustId") Long crustId) {
		return crustServ.getCrustById(crustId); 
	}
	
	@GetMapping("/crusts")
	public List<Crust> crusties() {
		return crustServ.getAllCrust(); 
	}
	
	@PostMapping("/create-crust")
	public void createCrust(@RequestBody Crust crust) {
		crustServ.createCrust(crust);
	}
	
	@PostMapping("/delete-crust")
	public void deleteCrust(@RequestBody Crust crust) {
		crustServ.deleteCrust(crust);
	}
	
}
