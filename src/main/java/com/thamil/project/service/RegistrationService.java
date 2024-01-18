package com.thamil.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamil.project.model.Registration;
import com.thamil.project.repository.RegistrationRepo;

@Service
public class RegistrationService {
  
  @Autowired
  private RegistrationRepo repo;

  public Registration saveRegistration(Registration registration){
    return repo.save(registration);
  }
}
