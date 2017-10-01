package com.zhi.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.pojo.User;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Integer> {
	public User findByOrders_User_Id(int user_id) throws Exception;
	public User findByName(String name) throws Exception;
	
	//@Query("select u.* from user u where u.name = :#{#user.name} and u.password = :#{#user.password}")
	public User findByNameAndPassword(String name, String password) throws Exception;
}
