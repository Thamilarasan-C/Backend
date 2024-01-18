package com.thamil.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thamil.project.exception.CustomException;
import com.thamil.project.model.Attendee;
import com.thamil.project.service.AttendeeService;


@RestController
@RequestMapping("attendee")
public class AttendeeController {
  
  @Autowired
  private AttendeeService service;
  
  @PostMapping("/saveAttendee")
  public ResponseEntity<Attendee> insertUser(@RequestBody Attendee attendee) throws CustomException {
    Attendee a = service.saveAttendee(attendee);
    return new ResponseEntity<Attendee>(a, HttpStatus.OK);
  }
}