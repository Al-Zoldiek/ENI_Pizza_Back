package fr.eni.ecole.app.ingredients.crust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrustController {

	@Autowired
	CrustService crustServ;
}
