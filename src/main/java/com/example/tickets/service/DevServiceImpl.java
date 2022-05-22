package com.example.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;
import com.example.tickets.repository.DevRepository;
import com.example.tickets.repository.TicketRepository;

@Service
public class DevServiceImpl implements DevService{
	
	@Autowired
	DevRepository devRepo;
	
	@Autowired
	TicketRepository ticketRepo;

	@Override
	public void addDev(Developpeur dev) {
		devRepo.save(dev);
		
	}

	@Override
	public List<Developpeur> getDevs() {
		return devRepo.findAll();
	}

	@Override
	public List<Ticket> getDevTickets(int idDev) {
		
		return ticketRepo.findByDev(idDev);
	}

	@Override
	public void updateTicketStatus(int idTicket,String status) {
		ticketRepo.updateTicketStatus(idTicket,status);
		
	}

	@Override
	public Developpeur findById(int idDev) {
		return devRepo.getById(idDev);
	}

}
