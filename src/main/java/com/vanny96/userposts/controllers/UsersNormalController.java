package com.vanny96.userposts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.services.UserService;

@Controller
public class UsersNormalController {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	@GetMapping("/users")
	public ModelAndView usersList(){
		ModelAndView model = new ModelAndView("users");
		model.addObject("users", userService.usersList());
		return model;
	}

	@GetMapping("/user/{id}")
	public AppUser getUser(@PathVariable Integer id){
		return userService.getUser(id);
	}

	@DeleteMapping("/user/{id}")
	public AppUser removeUser(@PathVariable Integer id){
		return userService.removeUser(id);
	}

	@PostMapping("/users")
	public AppUser addUser(@RequestBody AppUser user){
		System.out.println(user.getName());
		return userService.saveOrUpdateUser(user);
	}

	@GetMapping("/user/{id}/posts")
	public List<Post> getUserPosts(@PathVariable Integer id){
		return userService.getUser(id, true).getPosts();
	}
}
