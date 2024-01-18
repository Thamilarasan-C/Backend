package com.thamil.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thamil.project.exception.CustomException;
import com.thamil.project.model.Event;
import com.thamil.project.service.EventService;

@RestController
@RequestMapping(path = "event")
public class EventController {

  @Autowired
  private EventService service;

  @PostMapping("/saveEvent")
  public ResponseEntity<Event> insertEvent(@RequestBody Event event) throws CustomException {
    Event e = service.saveEvent(event);
    return new ResponseEntity<Event>(e, HttpStatus.OK);
  }
}