package com.example.tickets.service;

import java.util.List;

import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;

public interface DevService {
	
	
	public Developpeur findById(int idDev);
	public void addDev(Developpeur dev);
	public List<Developpeur> getDevs();
	
	public List<Ticket> getDevTickets(int idDev);
	public void updateTicketStatus(int idTicket,String status);

}
