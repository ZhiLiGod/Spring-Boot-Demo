package com.zhi.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.pojo.User;

@Transactional
public interface UserDao extends PagingAndSortingRepository<User, Integer> {
	public User findByOrders_User_Id(int user_id) throws Exception;
}
