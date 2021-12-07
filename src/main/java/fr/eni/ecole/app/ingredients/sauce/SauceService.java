package fr.eni.ecole.app.ingredients.sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SauceService {
	
	@Autowired
	SauceRepo sauceRepo;

}
