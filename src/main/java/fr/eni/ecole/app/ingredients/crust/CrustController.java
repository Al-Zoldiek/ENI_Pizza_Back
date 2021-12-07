package fr.eni.ecole.app.ingredients.crust;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrustController {

	@Autowired
	CrustService crustServ;
	
	@GetMapping("/crust")
	public Crust crust() {
		return crustServ.getCrustById(1L); 
	}
	
	@GetMapping("/crusties")
	public List<Crust> crusties() {
		return crustServ.getAllCrust(); 
	}
	
}
