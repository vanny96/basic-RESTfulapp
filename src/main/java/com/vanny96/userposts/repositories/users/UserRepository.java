package com.vanny96.userposts.repositories.users;

import java.util.List;

import com.vanny96.userposts.models.AppUser;

public interface UserRepository {

  List<AppUser> usersList();

  default AppUser getUser(Integer id){
    return getUser(id, false);
  }

  AppUser getUser(Integer id, boolean loadPosts);

  AppUser saveOrUpdateUser(AppUser user);

  AppUser removeUser(Integer id);
  
}