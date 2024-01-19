package com.thamil.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamil.project.model.TicketDetails;  
import com.thamil.project.repository.TicketDetailsRepo;
 
@Service
public class TicketDetailsService {

  @Autowired
  private TicketDetailsRepo repo;

  public TicketDetails saveTicketDetails(TicketDetails ticketDetails) {
    return repo.save(ticketDetails);
  }
  public void updateTicketCounts(Long eventId, int bookedTicketCount) {
    repo.updateTicketCount(eventId,bookedTicketCount);
  }
}
