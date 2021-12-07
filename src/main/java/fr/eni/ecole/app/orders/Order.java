package fr.eni.ecole.app.orders;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import fr.eni.ecole.app.pizzas.Pizza;

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
	
	@NotBlank
	private LocalDateTime date;
	
	@NotBlank	
	private String status;
	
	@ManyToMany	
	private List<Pizza> pizzasList;

	public Order(Long id, @NotBlank LocalDateTime date, @NotBlank String status, ArrayList<Pizza> pizzasList) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.pizzasList = pizzasList;
	}

	public Order() {
		super();
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
