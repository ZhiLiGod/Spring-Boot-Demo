package com.zhi.springboot.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.zhi.springboot.pojo.User;

@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
	
}
