package com.vanny96.userposts.services;

import java.util.List;

import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.repositories.posts.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService{
  private PostRepository postRepository;

  @Autowired
  public void setPostRepository(PostRepository postRepository) {
    this.postRepository = postRepository;
  }
  
  public List<Post> posts() {
    return postRepository.posts();
  }

  public Post getPost(Integer id) {
    return postRepository.getPost(id);
  }

  public Post savePost(Post post) {
    return postRepository.savePost(post);
  }

  public Post removePost(Integer id) {
    return postRepository.removePost(id);
  }

}