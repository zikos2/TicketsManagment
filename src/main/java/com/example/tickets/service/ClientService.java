package com.example.tickets.service;

import java.util.List;

import com.example.tickets.models.Client;
import com.example.tickets.models.Ticket;

public interface ClientService {
	
	public Client findById(int idClient);
	public void addClient(Client c);
	public List<Client> getClients();
	
	public List<Ticket> getClientTickets(int clientId);
	public void createTicket(Ticket ticket);

}
