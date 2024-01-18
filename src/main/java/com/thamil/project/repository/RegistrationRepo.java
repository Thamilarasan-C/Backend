package com.thamil.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thamil.project.model.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {

}
