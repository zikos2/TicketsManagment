package com.example.tickets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;
import com.example.tickets.service.DevServiceImpl;

@RestController
@RequestMapping("/dev")
public class DevController {
	
	@Autowired
	private DevServiceImpl devService;
	
	@PostMapping("/add")
	public void addDev(@RequestBody Developpeur dev) {
		 devService.addDev(dev);
	}
	
	
	@GetMapping("/{idDev}/tickets")
	public List<Ticket> getTickets(@PathVariable int idDev) {
		
		return devService.getDevTickets(idDev);
	}
	
	@GetMapping("/all")
	public List<Developpeur> getDevs() {
		return devService.getDevs();
	}
	
	
	@PostMapping("/tickets/{idTicket}/{state}")
	public void updateTicketState(@PathVariable int idTicket,@PathVariable String state) {
		devService.updateTicketStatus(idTicket,state);
	}

}
