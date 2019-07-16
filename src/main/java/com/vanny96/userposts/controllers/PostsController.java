package com.vanny96.userposts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.services.PostService;
import com.vanny96.userposts.services.UserService;

@Controller
public class PostsController {
	private PostService postService;
	private UserService userService;

	@Autowired
	public PostsController(PostService postService, UserService userService) {
		this.postService = postService;
		this.userService = userService;
	}

	@GetMapping("/posts")
	public ModelAndView getPosts(){
		ModelAndView model = new ModelAndView("/posts/posts");
		model.addObject("posts", postService.posts());
		
		return model;
	}

	@GetMapping("/post/{id}")
	public ModelAndView getPost(@PathVariable Integer id){
		ModelAndView model = new ModelAndView("/posts/post-view");
		model.addObject("post", postService.getPost(id));
		
		return model;
	}
	
	@GetMapping("/posts/new")
	public ModelAndView newPosts(@RequestParam(name="userId", required = true) Integer userId){
		ModelAndView model = new ModelAndView("/posts/post-form");
		model.addObject("post", new Post());
		model.addObject("userId", userId);
		
		return model;
	}

	@DeleteMapping("/post/{id}")
	public String removePost(@PathVariable Integer id){
		postService.removePost(id);
		return "redirect:/posts";
	}

	@PostMapping("/posts")
	public String savePost(@ModelAttribute("post") Post post, @RequestParam("user") Integer userId){
		System.out.println(userId);
		AppUser user = userService.getUser(userId);
		Post savedPost = postService.savePost(post, user);
		
		return "redirect:/post/"+savedPost.getId();
	}
}
