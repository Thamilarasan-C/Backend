package com.thamil.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.TicketDetails;

@Repository
public interface TicketDetailsRepo extends JpaRepository<TicketDetails,Long> {
  
}
