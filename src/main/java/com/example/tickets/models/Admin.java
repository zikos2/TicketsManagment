package com.example.tickets.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int idAdmin;
	private String name;
	private String lastName;
	
	
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
