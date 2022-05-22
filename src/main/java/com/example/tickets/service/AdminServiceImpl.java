package com.example.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tickets.models.Admin;
import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;
import com.example.tickets.repository.AdminRepository;
import com.example.tickets.repository.DevRepository;
import com.example.tickets.repository.TicketRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	DevRepository devRepo;

	@Override
	public List<Ticket> getNonAssignedTickets() {
		return ticketRepo.getUnassinged();
	}

	@Override
	public void assignTicket(int idTicket, int idDev,int idAdmin) {
		Developpeur d = devRepo.getById(idDev);
		Admin a = adminRepo.getById(idAdmin);
		ticketRepo.assignDev(idTicket,d,a);
		
	}

	@Override
	public void addAdmin(Admin admin) {
		adminRepo.save(admin);
		
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return ticketRepo.findAll();
	}

	@Override
	public Admin findById(int idAdmin) {
		// TODO Auto-generated method stub
		return adminRepo.getById(idAdmin);
	}

}
