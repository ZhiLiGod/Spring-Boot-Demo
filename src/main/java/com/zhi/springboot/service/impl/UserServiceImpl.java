package com.zhi.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhi.springboot.dao.UserDao;
import com.zhi.springboot.pojo.User;
import com.zhi.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> list = (List<User>) userDao.findAll();
		return list;
	}
	
	
	
}
