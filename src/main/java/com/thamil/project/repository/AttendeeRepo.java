package com.thamil.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.Attendee;
import com.thamil.project.model.Event;

@Repository
public interface AttendeeRepo extends JpaRepository<Attendee, Long> {

  @Query("SELECT a FROM Attendee a JOIN Ticket t ON t.attendeeId = a.attendeeId JOIN Registration r on r.registrationId = t.registrationId where r.eventId = :eventId")
  List<Attendee> findAttendeesByEventId(@Param("eventId") Long eventId);

}