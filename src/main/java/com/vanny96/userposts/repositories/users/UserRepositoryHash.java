package com.vanny96.userposts.repositories.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("hashmap")
public class UserRepositoryHash implements UserRepository{

  private Map<Integer, AppUser> users = new HashMap<Integer, AppUser>();

  public UserRepositoryHash(){
    AppUser user1 = new AppUser();
    user1.setName("Bob");
    user1.setEmail("bob@la.bob");
    user1.setId(1);
    user1.setPosts(new ArrayList<Post>());

    users.put(1, user1);

    AppUser user2 = new AppUser();
    user2.setName("Legolas");
    user2.setEmail("third@impact.bob");
    user2.setId(2);
    user2.setPosts(new ArrayList<Post>());


    users.put(2, user2);
  }

  
  public List<AppUser> usersList() {
    return new ArrayList<AppUser>(users.values());
  }

  public AppUser getUser(Integer id, boolean loadPosts) {
    AppUser user = users.get(id);
    user.getPosts();
    return user;
  }

  public AppUser saveOrUpdateUser(AppUser user) {
    if(user != null){      
      if(!users.values().contains(user)){
        user.setId(nextId());
        user.setPosts(new ArrayList<Post>());
      }

      users.put(user.getId(), user);
      return user;

    } else {
      throw new RuntimeException("user can't be null");
    }
  }

  public AppUser removeUser(Integer id) {
    AppUser removedUser = getUser(id);
    users.remove(id);

    return removedUser;
  }
  
  private int nextId(){
    return Collections.max(users.keySet()) + 1;
  }
}