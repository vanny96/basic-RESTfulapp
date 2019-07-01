package com.vanny96.userposts.repositories.posts;

import java.util.List;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;

public interface PostRepository {

  List<Post> posts();

  Post getPost(Integer id);

  Post savePost(Post post, AppUser user);

  Post removePost(Integer id);
}