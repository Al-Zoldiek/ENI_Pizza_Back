package fr.eni.ecole.app.ingredients.sauce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SauceController {

	@Autowired
	SauceService sauceServ;
}
