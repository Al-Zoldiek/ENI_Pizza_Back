package fr.eni.ecole.app.ingredients.toppings;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
public class Topping implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1193507421599007858L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String category;

	
	public Topping() {
		super();
	}

	
	public Topping(@NotBlank String name, @NotBlank String category) {
		super();
		this.name = name;
		this.category = category;
	}



	public Topping(Long id, @NotBlank String name, @NotBlank String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
