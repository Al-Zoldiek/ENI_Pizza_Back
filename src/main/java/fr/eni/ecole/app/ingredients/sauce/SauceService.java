package fr.eni.ecole.app.ingredients.sauce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SauceService {
	
	@Autowired
	SauceRepo sauceRepo;


	
	public Sauce getSauceById(Long id) {
		return sauceRepo.findById(id).get();
	}
	
	public List<Sauce> getAllSauce(){
		System.out.println("getAllCrust()");
		return sauceRepo.findAll();
		
	}
	
	public void createSauce(Sauce sauce) {
		sauceRepo.save(sauce);
	}
}
