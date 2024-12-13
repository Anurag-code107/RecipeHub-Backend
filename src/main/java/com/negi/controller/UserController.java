package com.negi.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.negi.model.User;
import com.negi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/user/profile")
	public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {
		
	    User user = userService.findUserByJwt(jwt);
	    return user;
	}
	
}
