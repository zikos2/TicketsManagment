package com.example.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTicket;
	private String description;
	private String urgency;
	private String state;
	private String environment;
	private String logiciel;
	
	
	@ManyToOne
	@JoinColumn(name = "idAdmin", nullable = true,
	        referencedColumnName = "idAdmin")
	private Admin assigne;
	
	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false,
	        referencedColumnName = "idClient")
	@JsonIgnoreProperties("tickets")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "idDev", nullable = true,
	        referencedColumnName = "idDev")
	@JsonIgnoreProperties("tickets")
	private Developpeur dev;

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getLogiciel() {
		return logiciel;
	}

	public void setLogiciel(String logiciel) {
		this.logiciel = logiciel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Developpeur getDev() {
		return dev;
	}

	public void setDev(Developpeur dev) {
		this.dev = dev;
	}

	public Admin getAssigne() {
		return assigne;
	}

	public void setAssigne(Admin assigne) {
		this.assigne = assigne;
	}
	
	
	
	
	
	
}
