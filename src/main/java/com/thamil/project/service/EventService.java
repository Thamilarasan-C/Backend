package com.thamil.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamil.project.model.Event;
import com.thamil.project.repository.EventRepo;

@Service
public class EventService {

  @Autowired
  private EventRepo repo;

  public Event saveEvent(Event event) {
    return repo.save(event);
  }
}
