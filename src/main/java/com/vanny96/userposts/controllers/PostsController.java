package com.vanny96.userposts.controllers;

import java.util.List;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.services.PostService;
import com.vanny96.userposts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController{
  private PostService postService;
  private UserService userService;

  @Autowired
  public void setPostService(PostService postService) {
    this.postService = postService;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/posts")
  public List<Post> getPosts(){
    return postService.posts();
  }

  @RequestMapping("/post/{id}")
  public Post getPost(@PathVariable Integer id){
    return postService.getPost(id);
  }

  @RequestMapping("/post/{id}/delete")
  public Post removePost(@PathVariable Integer id){
    return postService.removePost(id);
  }

  @RequestMapping(value = "/posts", method = RequestMethod.POST)
  public Post savePost(@RequestBody Post post, @RequestHeader(name = "userId") Integer userId){
    System.out.println("User id: " + userId);
    AppUser user = userService.getUser(userId);

    System.out.println(user.getName());
    return postService.savePost(post, user);
  }
}