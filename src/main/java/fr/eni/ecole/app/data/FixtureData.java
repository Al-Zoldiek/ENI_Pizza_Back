package fr.eni.ecole.app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.eni.ecole.app.ingredients.crust.Crust;
import fr.eni.ecole.app.ingredients.crust.CrustRepo;

@Component
public class FixtureData {
	
	
	@Autowired
	private CrustRepo crustRepository;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		crustRepository.save(new Crust("Fine"));
		crustRepository.save(new Crust("Epaisse"));
		crustRepository.save(new Crust("Mozza-crust"));
		crustRepository.save(new Crust("Classique"));
	}
}

