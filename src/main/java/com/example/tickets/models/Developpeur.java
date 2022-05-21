package com.example.tickets.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Developpeur {
	@Id
	private int idDev;
	private String name;
	private String lastName;
	
	@OneToMany(mappedBy = "dev",cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	public int getIdDev() {
		return idDev;
	}

	public void setIdDev(int idDev) {
		this.idDev = idDev;
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	

}
