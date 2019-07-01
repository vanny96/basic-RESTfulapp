package com.vanny96.userposts.repositories.users;

import java.util.List;

import com.vanny96.userposts.models.AppUser;

public interface UserRepository {

  List<AppUser> usersList();

  AppUser getUser(Integer id);

  AppUser saveOrUpdateUser(AppUser user);

  AppUser removeUser(Integer id);
  
}