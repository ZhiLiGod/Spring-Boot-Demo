package com.zhi.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.pojo.User;


public interface UserService {
	public void addUser(User user) throws Exception;

	public List<User> findAll() throws Exception;

	public List<Orders> findOrdersByUid(int user_id) throws Exception;
	public User findByOrdersUserId(int user_id) throws Exception;

	public User findUserByUsername(String name) throws Exception;

	public User findUserByUsernameAndPassword(String name, String password) throws Exception;
}	
