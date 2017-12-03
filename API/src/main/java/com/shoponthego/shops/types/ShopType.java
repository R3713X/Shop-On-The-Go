package com.shoponthego.shops.types;

public class ShopType {
	
	private int id;
	private String typeName;
	private String description;
	
	
	public ShopType(int id, String typeName, String description) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getDescription() {
		return description;
	}
}
