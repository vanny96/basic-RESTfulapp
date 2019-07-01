package com.vanny96.userposts.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vanny96.userposts.models.User;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("hashmap")
public class UserRepositoryHash implements UserRepository {

  private Map<Integer, User> users = new HashMap<Integer, User>();

  @Override
  public List<User> usersList() {
    return new ArrayList<User>(users.values());
  }

  @Override
  public User getUser(Integer id) {
    return users.get(id);
  }

  @Override
  public User saveOrUpdateUser(User user) {
    if(user != null){

      if(!users.values().contains(user)){
        user.setId(nextId());
      }

      users.put(user.getId(), user);
      return user;

    } else {
      throw new RuntimeException("user can't be null");
    }
  }

  @Override
  public User removeUser(Integer id) {
    User removedUser = getUser(id);
    users.remove(id);

    return removedUser;
  }
  
  private int nextId(){
    return Collections.max(users.keySet()) + 1;
  }
}