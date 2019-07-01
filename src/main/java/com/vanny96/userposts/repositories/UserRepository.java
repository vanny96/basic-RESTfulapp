package com.vanny96.userposts.repositories;

import java.util.List;

import com.vanny96.userposts.models.User;

public interface UserRepository {

  List<User> usersList();

  User getUser(Integer id);

  User saveOrUpdateUser(User user);

  User removeUser(Integer id);
  
}