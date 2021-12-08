package fr.eni.ecole.app.ingredients.crust;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrustService {
	
	@Autowired
	CrustRepo crustRepo;

	
	public Crust getCrustById(Long id) {
		return crustRepo.findById(id).get();
	}
	
	public List<Crust> getAllCrust(){
		System.out.println("getAllCrust()");
		return crustRepo.findAll();
		
	}
	
	public void createCrust(Crust crust) {
		crustRepo.save(crust);
	}
	
	public void deleteCrust(Crust crust) {
		crustRepo.delete(crust);
	}
	
}
