package com.thamil.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.TicketDetails;

@Repository
public interface TicketDetailsRepo extends JpaRepository<TicketDetails,Long> {
  @Query("UPDATE TicketDetails t SET t.ticketsAvailable = t.ticketsAvailable - :bookedTicketCount WHERE t.eventId = :eventId")
  void updateTicketCount(@Param("eventId") Long eventId , @Param("bookedTicketCount") int availableTicketCount);
}
