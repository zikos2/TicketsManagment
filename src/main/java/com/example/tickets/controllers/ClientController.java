package com.example.tickets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tickets.models.Client;
import com.example.tickets.models.Ticket;
import com.example.tickets.service.ClientServiceImpl;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientServiceImpl clientService;
	
	
	@GetMapping("/all")
	public List<Client> getClients() {
		return clientService.getClients();
	}
	
	@GetMapping("/{idClient}/tickets")
	public List<Ticket> getTickets(@PathVariable int idClient) {
		return clientService.getClientTickets(idClient);
	}
	
	
	@PostMapping("{idClient}/tickets/add")
	public void addTicket(@PathVariable int idClient,@RequestBody Ticket t) {
		Client client = clientService.findById(idClient);
		t.setClient(client);
		clientService.createTicket(t);
	}
	
	
	@PostMapping("/add")
	public void addClient(@RequestBody Client c) {
		
		 clientService.addClient(c);
	}
	

}
