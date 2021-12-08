package fr.eni.ecole.app.pizzas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import fr.eni.ecole.app.ingredients.crust.Crust;
import fr.eni.ecole.app.ingredients.sauce.Sauce;
import fr.eni.ecole.app.ingredients.toppings.Topping;
import lombok.Data;

@Entity
public class Pizza implements Serializable{
	
	private static final long serialVersionUID = 431978631785513179L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private double price;
	
	@ManyToMany	
	private List<Topping> toppingsList;
	
	@ManyToOne
	private Crust crust;
	@ManyToOne
	private Sauce sauce;
	
	public Pizza() {
	}
		
	public Pizza(@NotBlank String name, List<Topping> toppingsList, Crust crust, Sauce sauce) {
		super();
		this.name = name;
		this.toppingsList = toppingsList;
		this.crust = crust;
		this.sauce = sauce;
	}



	public Pizza(@NotBlank String name, @NotBlank double price, List<Topping> toppingsList, Crust crust, Sauce sauce) {
		this.name = name;
		this.price = price;
		this.toppingsList = toppingsList;
		this.crust = crust;
		this.sauce = sauce;
	}



	public Pizza(Long id, @NotBlank String name, @NotBlank double price, ArrayList<Topping> toppingsList, Crust crust,
			Sauce sauce) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.toppingsList = toppingsList;
		this.crust = crust;
		this.sauce = sauce;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public List<Topping> getToppingsList() {
		return toppingsList;
	}



	public void setToppingsList(List<Topping> toppingsList) {
		this.toppingsList = toppingsList;
	}



	public Crust getCrust() {
		return crust;
	}



	public void setCrust(Crust crust) {
		this.crust = crust;
	}



	public Sauce getSauce() {
		return sauce;
	}



	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
