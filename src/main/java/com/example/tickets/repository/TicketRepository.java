package com.example.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.tickets.models.Admin;
import com.example.tickets.models.Client;
import com.example.tickets.models.Developpeur;
import com.example.tickets.models.Ticket;

@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query("SELECT t FROM Ticket t WHERE t.dev IS NULL")
	List<Ticket> getUnassinged();
	
	
	@Modifying
	@Query("Update Ticket t set t.dev = :dev, t.assigne = :admin  where t.idTicket =  :idTicket")
	void assignDev( @Param("idTicket") int idTicket, @Param("dev") Developpeur d, @Param("admin") Admin a);

	
	@Query("Select t from Ticket t Where t.client = :client")
	List<Ticket> getClientTickets(Client client);
	
	
	
	@Query("Select t from Ticket t Where t.dev.idDev = :idDev")
	List<Ticket> findByDev(int idDev);
	
	@Modifying
	@Query("Update Ticket t set t.state = :state where t.idTicket =  :idTicket")
	void updateTicketStatus(@Param("idTicket") int idTicket,@Param("state") String state);
}
