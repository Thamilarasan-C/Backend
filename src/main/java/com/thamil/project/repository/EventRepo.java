package com.thamil.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Long>{
  
}
