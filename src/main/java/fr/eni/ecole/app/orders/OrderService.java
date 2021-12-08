package fr.eni.ecole.app.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	//A lier à un seul utilisateur
	//il faudra mettre une List<Order> dans User (plus tard)
	public List<Order> getAllOrder(){
		System.out.println("getAllOrder()");
		return orderRepo.findAll();
	}

	public void addOrder(Order order) {
		orderRepo.save(order);
	}
}
