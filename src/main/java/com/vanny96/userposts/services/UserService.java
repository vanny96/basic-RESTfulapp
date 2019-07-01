package com.vanny96.userposts.services;

import java.util.List;

import com.vanny96.userposts.models.User;
import com.vanny96.userposts.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
  private UserRepository userRepository;

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> usersList(){
    return userRepository.usersList();
  }

  public User getUser(Integer id){
    return userRepository.getUser(id);
  }

  public User saveOrUpdateUser(User user){
    return userRepository.saveOrUpdateUser(user);
  }

  public User removeUser(Integer id){
    return userRepository.removeUser(id);
  }

}