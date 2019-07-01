package com.vanny96.userposts.controllers;

import java.util.List;

import com.vanny96.userposts.models.User;
import com.vanny96.userposts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController{
  private UserService userService;

  @Autowired
  public void setUserService(UserService userService){
    this.userService = userService;
  }

  @RequestMapping("/users")
  public List<User> usersList(){
    return userService.usersList();
  }

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable Integer id){
    return userService.getUser(id);
  }

  @RequestMapping("/user/{id}/delete")
  public User removeUser(@PathVariable Integer id){
    return userService.removeUser(id);
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public User addUser(@RequestBody User user){
    System.out.println(user.getName());
    return userService.saveOrUpdateUser(user);
  }
}