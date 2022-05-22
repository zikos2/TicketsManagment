package com.example.tickets.mvcControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.tickets.models.Admin;
import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;
import com.example.tickets.service.AdminServiceImpl;
import com.example.tickets.service.DevServiceImpl;

@Controller
@RequestMapping("/mvc/admin")
public class AdminControllerMVC {

	
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	DevServiceImpl devService;
	
	@GetMapping
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("admin/list");
		m.addObject("admins", adminService.getAdmins());
		return m;
	}

	@GetMapping("/add")
	public String ajout(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin/add";

	}

	@PostMapping("/add")
	public String addAdmin(@ModelAttribute("admin") Admin admin) {
		System.out.println("added: "+admin.getIdAdmin());
		System.out.println("added: "+admin.getLastName());
			Admin ad = new Admin(admin.getName(),admin.getLastName());
			adminService.addAdmin(ad);
		return "admin/list";
	}
	
	
	@GetMapping("/tickets/unassigned")
	public ModelAndView getUnAssignedTickets() {
		ModelAndView m = new ModelAndView("admin/tickets");
		m.addObject("tickets", adminService.getNonAssignedTickets());
		m.addObject("devs", devService.getDevs());
		return m;
	}
	
	
	@GetMapping("/{idAdmin}/tickets/{idTicket}/assign/{idDev}")
	public String assignTicketToDev(@PathVariable int idAdmin,@PathVariable int idTicket,@PathVariable int idDev) {
		ModelAndView m = new ModelAndView("admin/tickets");
		m.addObject("tickets", adminService.getNonAssignedTickets());
		m.addObject("devs", devService.getDevs());

		adminService.assignTicket(idTicket,idDev,idAdmin);
		return "tickets/unassigned";
	}
	
	
	
	
}
