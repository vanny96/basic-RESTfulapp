package com.vanny96.userposts.repositories.posts;

import java.util.List;

import com.vanny96.userposts.models.Post;

public interface PostRepository {

  List<Post> posts();

  Post getPost(Integer id);

  Post savePost(Post post);

  Post removePost(Integer id);
}