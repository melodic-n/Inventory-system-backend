package com.example.Inventory.system.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "storemanager") 
public class StoreManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	
	public StoreManager(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
