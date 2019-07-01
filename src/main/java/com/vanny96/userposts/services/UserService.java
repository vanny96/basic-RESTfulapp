package com.vanny96.userposts.services;

import java.util.List;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.repositories.users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
  private UserRepository userRepository;

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<AppUser> usersList(){
    return userRepository.usersList();
  }

  public AppUser getUser(Integer id){
    return userRepository.getUser(id);
  }

  public AppUser saveOrUpdateUser(AppUser user){
    return userRepository.saveOrUpdateUser(user);
  }

  public AppUser removeUser(Integer id){
    return userRepository.removeUser(id);
  }

}