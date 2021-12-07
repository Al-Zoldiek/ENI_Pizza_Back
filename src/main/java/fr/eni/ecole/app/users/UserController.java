package fr.eni.ecole.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public void home() {
		System.out.println(userService.getUserById((long) 1));
	}
}
