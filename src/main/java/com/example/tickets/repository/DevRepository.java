package com.example.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tickets.models.Developpeur;

public interface DevRepository extends JpaRepository<Developpeur, Integer> {

}
