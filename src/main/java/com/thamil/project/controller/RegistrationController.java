package com.thamil.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thamil.project.model.Registration;
import com.thamil.project.service.RegistrationService;


@RestController
@RequestMapping(path = "registration")
public class RegistrationController {
  
  @Autowired
  private RegistrationService service;

  @PostMapping("addRegistration")
  public ResponseEntity<Registration> insertRegistration(@RequestBody Registration registration) {
    Registration r = service.saveRegistration(registration);
    return new ResponseEntity<Registration>(r,HttpStatus.OK);
  }
  
}
