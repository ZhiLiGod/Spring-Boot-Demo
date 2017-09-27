package com.zhi.springboot.service;

import java.util.List;

import com.zhi.springboot.pojo.User;

public interface UserService {
	public void addUser(User user) throws Exception;

	public List<User> findAll() throws Exception;
}	
