package fr.eni.ecole.app.ingredients.crust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrustService {
	
	@Autowired
	CrustRepo crustRepo;

}
