package com.example.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tickets.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
