package fr.eni.ecole.app.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

//	public User getAllUsers() {
//		List<User> usersList = new ArrayList<User>(userRepo.findAll());
//		
//	}
	
	public User getUserById(Long id) {
		
		User userRetrieved = userRepo.getById(id);
		return userRetrieved;
	}
}
