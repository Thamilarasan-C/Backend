package com.thamil.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.Attendee;

@Repository
public interface AttendeeRepo extends JpaRepository<Attendee,Long> {
  
}