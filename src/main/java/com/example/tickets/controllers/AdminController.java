package com.example.tickets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tickets.models.Admin;
import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;
import com.example.tickets.service.AdminServiceImpl;
import com.example.tickets.service.DevServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private DevServiceImpl devService;
	
	@GetMapping("/tickets/all")
	public List<Ticket> getTickets() {
		return adminService.getTickets();
	}
	
	@GetMapping("/all")
	public List<Admin> getAdmins() {
		return adminService.getAdmins();
	}
	
	
	@GetMapping("/tickets/unassigned")
	public List<Ticket> getUnAssignedTickets() {
		return adminService.getNonAssignedTickets();
	}
	
	 
	@PostMapping("/new")
	public void add(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
	}
	
	
	@PostMapping("/{idAdmin}/ticket/{idTicket}/assign/{idDev}")
	public void assignTicket(@PathVariable int idAdmin, @PathVariable int idTicket,@PathVariable int idDev) {
		Developpeur dev = devService.findById(idDev);
		Admin admin = adminService.findById(idDev);
		adminService.assignTicket(idTicket, idDev, idAdmin);
	}
}
