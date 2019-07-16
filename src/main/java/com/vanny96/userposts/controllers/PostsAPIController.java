package com.vanny96.userposts.controllers;

import java.util.List;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.services.PostService;
import com.vanny96.userposts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostsAPIController{
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

  @GetMapping("/posts")
  public List<Post> getPosts(){
    return postService.posts();
  }

  @GetMapping("/post/{id}")
  public Post getPost(@PathVariable Integer id){
    return postService.getPost(id);
  }

  @DeleteMapping("/post/{id}")
  public Post removePost(@PathVariable Integer id){
    return postService.removePost(id);
  }

  @PostMapping("/posts")
  public Post savePost(@RequestBody Post post, @RequestHeader(name = "userId") Integer userId){
    System.out.println("User id: " + userId);
    AppUser user = userService.getUser(userId);

    System.out.println(user.getName());
    return postService.savePost(post, user);
  }
}