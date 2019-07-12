package com.vanny96.userposts.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vanny96.userposts.models.AppUser;
import com.vanny96.userposts.models.Post;
import com.vanny96.userposts.services.UserService;

@Controller
public class UsersController {
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
	public ModelAndView getUser(@PathVariable Integer id){
		ModelAndView model = new ModelAndView("user-view");
		model.addObject("user", userService.getUser(id, true));
		
		return model;
	}

	@DeleteMapping("/user/{id}")
	public AppUser removeUser(@PathVariable Integer id){
		return userService.removeUser(id);
	}
	
	@GetMapping("/users/new")
	public ModelAndView newUser(){
		ModelAndView model = new ModelAndView("user-form");
		model.addObject("user", new AppUser());
		
		return model;
	}

	@PostMapping("/users")
	public String addUser(@Valid @ModelAttribute("user") AppUser user){
		AppUser savedUser =userService.saveOrUpdateUser(user);
		return "redirect:/user/"+savedUser.getId();
	}

	@GetMapping("/user/{id}/posts")
	public List<Post> getUserPosts(@PathVariable Integer id){
		return userService.getUser(id, true).getPosts();
	}
}
