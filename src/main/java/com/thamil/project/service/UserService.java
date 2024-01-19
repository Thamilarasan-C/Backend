package com.thamil.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamil.project.exception.CustomException;
import com.thamil.project.model.User;
import com.thamil.project.repository.UserRepo;

@Service
public class UserService {
  @Autowired
  private UserRepo repo;

  public User saveUser(User user) throws CustomException {
    if (user.getEmailId() == null)
      throw new CustomException("Email Id must not be null");
    if (user.getEmailId() != null && repo.existsByEmailId(user.getEmailId()))
      throw new CustomException("Email Id already registered");
    return repo.save(user);
  }

  public User updateUser(User user) throws CustomException {
    if (user.getEmailId() == null)
      throw new CustomException("Email Id must not be null");
    if (repo.existsByEmailId(user.getEmailId()))
      return repo.save(user);
    throw new CustomException("No user found in this id");
  }

}