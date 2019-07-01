package com.vanny96.userposts.controllers;

import java.util.List;

import com.vanny96.userposts.models.AppUser;
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
  public List<AppUser> usersList(){
    return userService.usersList();
  }

  @RequestMapping("/user/{id}")
  public AppUser getUser(@PathVariable Integer id){
    return userService.getUser(id);
  }

  @RequestMapping("/user/{id}/delete")
  public AppUser removeUser(@PathVariable Integer id){
    return userService.removeUser(id);
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public AppUser addUser(@RequestBody AppUser user){
    System.out.println(user.getName());
    return userService.saveOrUpdateUser(user);
  }
}