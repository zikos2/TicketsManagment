package com.example.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tickets.models.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {

}
