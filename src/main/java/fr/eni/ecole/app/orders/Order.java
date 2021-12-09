package fr.eni.ecole.app.orders;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import fr.eni.ecole.app.pizzas.Pizza;
import fr.eni.ecole.app.users.User;

@Entity
@Table(name="pizzas_order")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1471028713836927771L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime date;

	@NotBlank	
	private String status;

	@ManyToMany	
	private List<Pizza> pizzasList;

	@OneToOne
	private User user;

	public Order() {
		super();
	}
	
	public Order(LocalDateTime date, @NotBlank String status, List<Pizza> pizzasList) {
		super();
		this.date = date;
		this.status = status;
		this.pizzasList = pizzasList;
	}


	public Order(Long id,LocalDateTime date, @NotBlank String status, ArrayList<Pizza> pizzasList) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.pizzasList = pizzasList;
	}
	
	public Order(@NotBlank String status, List<Pizza> pizzasList, User user) {
		super();
		this.status = status;
		this.pizzasList = pizzasList;
		this.user = user;
	}

	public Order(LocalDateTime date, @NotBlank String status, List<Pizza> pizzasList, User user) {
		super();
		this.date = date;
		this.status = status;
		this.pizzasList = pizzasList;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Pizza> getPizzasList() {
		return pizzasList;
	}

	public void setPizzasList(List<Pizza> pizzasList) {
		this.pizzasList = pizzasList;
	}



}
