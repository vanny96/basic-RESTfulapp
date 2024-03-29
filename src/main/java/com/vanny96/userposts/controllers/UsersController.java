package com.vanny96.userposts.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vanny96.userposts.models.AppUser;
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
		ModelAndView model = new ModelAndView("/users/users");
		model.addObject("users", userService.usersList());
		return model;
	}

	@GetMapping("/user/{id}")
	public ModelAndView getUser(@PathVariable Integer id){
		ModelAndView model = new ModelAndView("/users/user-view");
		model.addObject("user", userService.getUser(id, true));
		
		return model;
	}

	@GetMapping("/user/{id}/delete")
	public String removeUser(@PathVariable Integer id){
		userService.removeUser(id);
		return "redirect:/users";
	}
	
	@GetMapping("/users/new")
	public ModelAndView newUser(){
		ModelAndView model = new ModelAndView("/users/user-form");
		model.addObject("user", new AppUser());
		
		return model;
	}

	@PostMapping("/users")
	public String addUser(@Valid @ModelAttribute("user") AppUser user){
		AppUser savedUser =userService.saveOrUpdateUser(user);
		return "redirect:/user/"+savedUser.getId();
	}
	
	@GetMapping("/user/{id}/edit")
	public ModelAndView editUser(@PathVariable Integer id){
		ModelAndView model = new ModelAndView("/users/user-form");
		model.addObject("user", userService.getUser(id));	
		return model;
	}

}
