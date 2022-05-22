package com.example.tickets.service;

import java.util.List;

import com.example.tickets.models.Admin;
import com.example.tickets.models.Ticket;

public interface AdminService {

	public Admin findById(int idAdmin);
	public void addAdmin(Admin admin);
	public List<Admin> getAdmins();
	public List<Ticket> getTickets();
	
	
	public List<Ticket> getNonAssignedTickets();
	public void assignTicket(int idTicket,int idDev,int idAdmin);
	
}
