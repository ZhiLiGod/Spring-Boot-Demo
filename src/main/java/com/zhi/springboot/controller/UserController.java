package com.zhi.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhi.springboot.pojo.User;
import com.zhi.springboot.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String addUser(@RequestBody User user) throws Exception{
		userService.addUser(user);
		return "Successful";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public List<User> findAll() throws Exception{
		return userService.findAll();
	}
	
}
