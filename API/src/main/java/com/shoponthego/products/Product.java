package com.shoponthego.products;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private String id;
	private String name;
	private String description;
	private double price;
	
	public Product() {
		
	}
	
	public Product(String newId, String newName, String newDescription, double newPrice) {
		id = newId;
		name = newName;
		description = newDescription;
		price = newPrice;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}	
	
}
