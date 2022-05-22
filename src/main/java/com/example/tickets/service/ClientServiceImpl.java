package com.example.tickets.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tickets.models.Client;
import com.example.tickets.models.Ticket;
import com.example.tickets.repository.ClientRepository;
import com.example.tickets.repository.TicketRepository;


@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	TicketRepository ticketRepo;

	@Override
	public List<Ticket> getClientTickets(int clientId) {
		Client client = clientRepo.getById(clientId);
		
		return client.getTickets();
	}

	@Override
	public void createTicket(Ticket t) {
		Client client =  clientRepo.getById(t.getClient().getIdClient());
		List<Ticket> tickets = client.getTickets();
		tickets.add(t);
		client.setTickets(tickets);
		clientRepo.save(client);
		
		ticketRepo.save(t);
		
	}

	@Override
	public void addClient(Client c) {
		clientRepo.save(c);
		
	}

	@Override
	public List<Client> getClients() {
		return clientRepo.findAll();
	}

	@Override
	public Client findById(int idClient) {
		// TODO Auto-generated method stub
		return clientRepo.getById(idClient);
	}

}
