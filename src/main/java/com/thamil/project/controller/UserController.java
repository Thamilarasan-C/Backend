package com.thamil.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thamil.project.exception.CustomException;
import com.thamil.project.model.User;
import com.thamil.project.service.UserService;

@RestController
@RequestMapping(path = "user")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/signUp")
  public ResponseEntity<User> insertUser(@RequestBody User user) throws CustomException {
    User u = service.saveUser(user);
    return new ResponseEntity<User>(u, HttpStatus.OK);
  }
}
