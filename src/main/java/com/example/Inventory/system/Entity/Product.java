package com.example.Inventory.system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products" )
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name ="Category")
	private String Category;
	@Column(name = "unit")
	private int unit;
	@Column(name = "unitary_price")
	private float unitary_price;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String category, int unit, float unitary_price) {
		this.name = name;
		this.Category = category;
		this.unit = unit;
		this.unitary_price = unitary_price;
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
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public float getUnitary_price() {
		return unitary_price;
	}
	public void setUnitary_price(float unitary_price) {
		this.unitary_price = unitary_price;
	}


}
