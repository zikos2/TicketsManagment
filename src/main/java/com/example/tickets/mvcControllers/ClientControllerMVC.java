package com.example.tickets.mvcControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.tickets.service.ClientServiceImpl;


@Controller
@RequestMapping("/mvc/admin")
public class ClientControllerMVC {
	
	@Autowired
	ClientServiceImpl clientService;
	

}
