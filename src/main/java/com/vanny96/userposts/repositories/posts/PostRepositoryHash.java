package com.vanny96.userposts.repositories.posts;

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
public class PostRepositoryHash implements PostRepository {
  private Map<Integer, Post> posts;

  public PostRepositoryHash(){
    posts = new HashMap<Integer, Post>();
  }

  @Override
  public List<Post> posts() {
    return new ArrayList<Post>(posts.values());
  }

  @Override
  public Post getPost(Integer id) {
    return posts.get(id);
  }

  @Override
  public Post savePost(Post post, AppUser user) {
    if( post != null && user != null){

      post.setId(getNextId());
      posts.put(post.getId(), post);

      
      user.addPost(post);

      return post;
    } else {
      throw new RuntimeException("post or userIdmissing");
    }
  }

  @Override
  public Post removePost(Integer id) {
    return posts.remove(id);
  }
  
  private Integer getNextId(){
    Integer id;
    if(posts.isEmpty()){
      id = 1;
    } else {
      id = Collections.max(posts.keySet());
    } 
    return id;
  }
}